package io.renren.business.domin.deviceConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gateway_conf {

    private String gateway_ID;
    private String group_hash;
    private String gwtype;
    private String server_address;
    private int serv_port_up;
    private int serv_port_down;

}
