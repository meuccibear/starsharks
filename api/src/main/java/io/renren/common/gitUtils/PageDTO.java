package io.renren.common.gitUtils;

import com.alibaba.fastjson.annotation.JSONField;
import io.renren.common.utils.Constant;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO implements Serializable {

    @ApiParam(value = "用户编号")
    private Long userId;

    @ApiParam(value = "类型 0.超级管理员 1.其他")
    private Integer type = 1;

    @ApiParam(defaultValue = "1", value = "当前页(不填默认1)")
    private Integer pageNo = 1;

    @ApiParam(defaultValue = "10", value = "当前页展示数量(不填默认10)")
    private Integer pageSize;
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
        pageConvertLine = (pageNo - 1) * pageSize;
        return pageConvertLine;
    }

    public void build(Long userId) {
        setUserId(userId);

        //系统管理员，拥有最高权限
        if (userId  == Constant.SUPER_ADMIN) {
            setType(0);
        }
    }
}
