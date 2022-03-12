package io.renren.business.domin.deviceConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Gateway {

    private Gateway_conf gateway_conf;

    public static String build(String gateway_ID, String grName, String ip, int port) {
        Gateway_conf gateway_conf = new Gateway_conf();
        gateway_conf.setGateway_ID(gateway_ID);
        gateway_conf.setGroup_hash(grName);
        gateway_conf.setGwtype("internal");
        gateway_conf.setServer_address(ip);
        gateway_conf.setServ_port_up(port);
        gateway_conf.setServ_port_down(port);
        Gateway gatewayConf = new Gateway();
        gatewayConf.setGateway_conf(gateway_conf);


        String json = "{\n" +
                "  \"gateway_conf\": {\n" +
                "    \"gateway_ID\": \"" + gateway_conf.getGateway_ID() + "\",\n" +
                "    \"group_hash\": \"" + gateway_conf.getGroup_hash() + "\",\n" +
                "    \"gwtype\": \"internal\",\n" +
                "    \"serv_port_down\": " + gateway_conf.getServ_port_down() + ",\n" +
                "    \"serv_port_up\": " + gateway_conf.getServ_port_up() + ",\n" +
                "    \"server_address\": \"" + gateway_conf.getServer_address() + "\"\n" +
                "  }\n" +
                "}\n";
        return json;
    }
}
