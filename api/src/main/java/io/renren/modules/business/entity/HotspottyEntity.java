package io.renren.modules.business.entity;

import io.renren.modules.helium.domain.Device;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@Data
public class HotspottyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Long hotspottyId;
    /**
     * 名称
     */
    private String name;
    /**
     * 内网IP
     */
    private String privateIp;
    /**
     * 公网IP
     */
    private String publicIp;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 房间
     */
    private String room;
    /**
     * 设备状态
     */
    private String online;
    /**
     * 国家
     */
    private String country;
    /**
     * 城市
     */
    private String city;
    /**
     * 街道
     */
    private String street;
    /**
     * Hex
     */
    private String hex;
    /**
     * 24小时收益
     */
    private Double total24h;
    /**
     * 7天收益
     */
    private Double total1d;
    /**
     * 30天收益
     */
    private Double total30d;
    /**
     * 钱包地址
     */
    private String owner;
    /**
     * 设备地址
     */
    private String address;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 创建者ID
     */
    private Long groupId;
    private Long createUserId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    private String groupName;

    public void setAddDevice(Device device) {
        setName(device.getName());
        setOnline(device.getStatus().getOnline());
        setCountry(device.getGeocode().getLong_country());
        setCity(device.getGeocode().getLong_city());
        setStreet(device.getGeocode().getLong_street());
        setHex(device.getLocation_hex());
        setTotal24h(device.getTotal());
        setOwner(device.getOwner());
        setAddress(device.getAddress());
        setCreateTime(new Date());
        setUpdateTime(new Date());
        setStatus(1);
    }


    public void setUpdateDevice(long id, Device device) {
        setHotspottyId(id);
        setOnline(device.getStatus().getOnline());
        setCountry(device.getGeocode().getLong_country());
        setCity(device.getGeocode().getLong_city());
        setStreet(device.getGeocode().getLong_street());
        setHex(device.getLocation_hex());
        setTotal24h(device.getTotal());
        setUpdateTime(new Date());
        setStatus(1);
    }

}
