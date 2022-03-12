package io.renren.business.domin.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompletedRewardsBean {
    private int days;
    private List<String> hotspotIds;

}
