package io.renren.modules.helium.domain.deviceConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gateway_conf {

    private String gateway_ID;
    private String group_hash;
    // internal  output
    private String gwtype;
    private String server_address;
    private int serv_port_up;
    private int serv_port_down;

}
