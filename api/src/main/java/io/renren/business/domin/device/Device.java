package io.renren.business.domin.device;

import com.alibaba.fastjson.JSONObject;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.DateUtils;
import io.renren.common.gitUtils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: HNTD
 * @ClassName BasicBean
 * @description:
 * @author: Mr.Lv
 * @email: lvzhuozhuang@foxmail.com
 * @create: 2022-01-27 17:14
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Device extends BasicBean {

    private String hex;
    private BigDecimal lng;
    private BigDecimal lat;
    private Object timestamp_added;
    private Status status;
    private Double reward_scale;
    private String payer;
    private String owner;
    private int nonce;
    private String name;
    private String mode;
    private String location_hex;
    private String location;
    private long last_poc_challenge;
    private long last_change_block;
    private Geocode geocode;
    private int gain;
    private int elevation;
    private long block_added;
    private long block;
    private String address;
    private double total;

    public LocalDateTime getTimestampAdded() {
        if (timestamp_added instanceof String) {
            setTimestamp_added(DateUtils.asLocalDateTime(DateUtils.toDate((String) timestamp_added)));
        }
        return (LocalDateTime) timestamp_added;
    }

    @Override
    public String toString() {

        JSONObject jsonObject = BeanUtils.toJSON(this);
        List<String> WLV = new ArrayList<>();
        String[] clos = "index,blacklistedBatch,mac,privateIp,publicIp,network,name,total,lng,lat,nonce,owner,address,location_hex".split(",");
        for (String clo : clos) {
            switch (clo) {
                case "lng":
                    WLV.add(getGeocode().getLong_country());
                    WLV.add(getGeocode().getLong_city());
                    WLV.add(getStatus().getOnline());
                    WLV.add(StringUtils.outStr(" ", getStatus().getListen_addrs().toArray()));
                    WLV.add(String.valueOf(getLng()));
                    break;
                default:
                    WLV.add(String.valueOf(jsonObject.get(clo)));
                    break;
            }
        }

        return StringUtils.outStr(",", WLV.toArray());

//        return StringUtils.outStr(",",
//                getName().replaceAll("-", " "),
//                getGeocode().getShort_country(),
//                getGeocode().getLong_country(),
//                getStatus().getOnline(),
//                getTotal() + "",
//                getOwner() + "",
//                JSON.toJSONString(getStatus().getListen_addrs()));
    }
}
