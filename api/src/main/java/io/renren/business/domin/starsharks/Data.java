package io.renren.business.domin.starsharks;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Data {

    private String sort_by;
    private int total_count;
    private int total_page;
    private int curr_page;
    private List<String> sharks;
}
