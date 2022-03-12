package io.renren.business;

import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.Result;
import io.renren.business.domin.device.CompletedRewardsBean;
import io.renren.business.domin.device.Device;
import io.renren.business.domin.deviceConfig.Gateway;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.ObjectUtils;
import io.renren.common.gitUtils.StringUtils;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.gitUtils.http.FileUtils;
import io.renren.common.gitUtils.http.HttpResultData;
import io.renren.common.gitUtils.http.HttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: starsharks
 * @ClassName Helium
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-03-02 15:48
 * @Version 1.0
 **/
public class HeliumDemo {
    // 导出文件的目录
    static String filderPath = System.getProperty("user.dir");


    /**
     * 导出 设备配置文件
     * @param index         设备开始编号
     * @param port          端口 eg: 山猫：1680 黑豹: 1681
     * @param groupIndex    分组开始编号
     * @param groupName     分组名称
     * @param arr           IP 数据
     */
    public void exportGateway(int index, int port, int groupIndex, String groupName, String[] arr) {

        String[] ips;
        for (int i = 0; i < arr.length; i++) {
            ips = arr[i].split("\n");
            exportGatewaySon(ips, port, String.format("%s%daf",
                    groupName, ++groupIndex), index);
            index += ips.length;
        }
        StringUtils.writeList("\t", index, groupIndex, groupName);

    }

    /**
     * 获取多个随机位置
     * @throws MsgException
     */
    public static void getRandomLocations(String hexPath, String... groupS) throws MsgException {

        List<Device> devices = new ArrayList<>();
        hexUtils = new HexUtils(hexPath);
        for (String group : groupS) {
            String[] hexS = group.split("&");
            for (String hex : hexS) {
                String[] valS = hex.split("\\^");
                devices.addAll(getRandomDevices(valS[0], Integer.parseInt(valS[1])));
            }
        }

        for (Device device : devices) {
            StringUtils.writeList("\t", device.getHex(), String.valueOf(device.getLat()), String.valueOf(device.getLng()));
        }
    }

    /**
     * @param ips        ip字符串组 &:组分隔符 ,:ip分隔符
     * @param port       端口 eg: 山猫：1680 黑豹: 1681
     * @param grName     组名    eg:"hncz1"
     * @param startIndex 开始序号  eg:0
     */
    public static void exportGatewaySon(String[] ips, int port, String grName, int startIndex) {

        for (int i = 0; i < ips.length; i++) {
            ++startIndex;
            try {
                FileUtils.write(String.format(filderPath + "\\gateway\\gateway_%s_%s.json",
                                grName, ips[i].replaceAll("\\.", "_")),
                        Gateway.build(StringUtils.toTempStr("0000000000000000",
                                        String.valueOf(startIndex)),
                                grName, ips[i], port));
            } catch (MsgException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static HexUtils hexUtils;
    /**
     * 随机多个设备
     * @param hex 区域碎片代码
     * @param num 随机数量
     * @return
     * @throws MsgException
     */
    public static List<Device> getRandomDevices( String hex, int num) throws MsgException {
//        System.out.println(path);
//        String jsonStr = FileUtils.readLine(String.format(initRandomDevicePath, path));
//        System.out.println(jsonStr);
//        CompletedRewardsBean completedRewardsBean = BeanUtils.mergeObjects(CompletedRewardsBean.class, jsonStr);
//        hexUtils = new HexUtils(path);
        CompletedRewardsBean completedRewardsBean = hexUtils.getHex(hex);
        List<Device> devices = new ArrayList<>();
        Device device;
        for (int i = 0; i < num; i++) {
            device = getRandomDevice(completedRewardsBean);
            device.setHex(hex);
            devices.add(device);
//            System.out.println(String.format("hex\treward_scale: %s address: %s", device.getReward_scale(), device.getAddress()));
//            System.out.println(String.format("%s\t%s address: %s", hex, device.getReward_scale(), device.getAddress()));
        }
        return devices;
    }


    /**
     * 随机设备【递归|单用】
     *
     * @return
     * @throws MsgException
     */
    public static Device getRandomDevice(CompletedRewardsBean completedRewardsBean) throws MsgException {

        if (ObjectUtils.notIsEmpty(completedRewardsBean) && ObjectUtils.notIsEmpty(completedRewardsBean.getHotspotIds())) {
            String id = completedRewardsBean.getHotspotIds().get(NumUtils.intervalRandom(completedRewardsBean.getHotspotIds().size()));
            completedRewardsBean.getHotspotIds().remove(id);
            Device device = getDevice(id);
//            if (ObjectUtils.isEmpty(device) && ObjectUtils.isEmpty(device.getReward_scale())) {
            if (ObjectUtils.isEmpty(device) && device.getStatus().getOnline().equals("")) {
                if (ObjectUtils.isEmpty(device.getReward_scale())) {
                    StringUtils.writeList("\t", device.getStatus().getOnline(), device.getAddress());
                }
                return getRandomDevice(completedRewardsBean);
            }
            return device;
        }

        throw new MsgException("没有可以使用的位置设备了");
    }

    /**
     * 获取
     *
     * @param id
     * @return
     * @throws MsgException
     */
    public static Device getDevice(String id) throws MsgException {
        Result result = BeanUtils.toJavaObject(get(String.format("https://helium-api.stakejoy.com/v1/hotspots/%s", id)), new TypeReference<Result>() {
        });
        return BeanUtils.toJavaObject(result.getData(), new TypeReference<Device>() {
        });
    }

    /**
     * get请求
     *
     * @param url 链接
     * @return
     * @throws MsgException
     */
    public static String get(String url) throws MsgException {
        HttpResultData httpResultData = HttpUtils.get(url);
        return httpResultData.getResult();
    }

}
