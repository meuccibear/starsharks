package io.renren.business.domin.starsharks;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class StarsharksRestBean {

    private int code;
    private String message;
    private Data data;
}
