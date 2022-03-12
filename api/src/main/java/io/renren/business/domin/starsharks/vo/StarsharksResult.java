package io.renren.business.domin.starsharks.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class StarsharksResult {

    public int curr_page;

    public int total_page;

    public int total_count;

    public String sort_by;

    List<Shark> sharkList;

}
