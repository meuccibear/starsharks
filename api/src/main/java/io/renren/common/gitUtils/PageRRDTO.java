package io.renren.common.gitUtils;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRRDTO implements Serializable {

    @ApiParam(value = "用户编号")
    private Long createUserId;

    @ApiParam(defaultValue = "1", value = "当前页(不填默认1)")
    private Integer page = 1;

    @ApiParam(defaultValue = "10", value = "当前页展示数量(不填默认10)")
    private Integer limit;

    @ApiParam(defaultValue = "", value = "筛选")
    private String key;

//    private String path;

    /**
     * 页数 转换 数据行数
     */
    @JSONField(ordinal = 3, deserialize = false, serialize = false)
    @ApiParam(hidden = true, required = false)
    int pageConvertLine;

    /**
     * 页数 转换 数据行数
     * @return 数据行数
     */
    public Integer getPageConvertLine() {
        pageConvertLine = (page - 1) * limit;
        return pageConvertLine;
    }

    public void build(Long userId) {
        setCreateUserId(userId);
    }
}
