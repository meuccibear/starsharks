package io.renren.common.gitUtils;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVO {


    @ApiParam(value = "当前页数")
    private Integer pageNo;

    @ApiParam(value = "列表数据")
    private List<?> data;

    @ApiParam(value = "每页记录数")
    private Integer pageSize;

    @ApiParam(value = "总记录数")
    private Integer totalCount;

    @ApiParam(value = "总页数")
    private Integer totalPage;

    @ApiParam(value = "类型 0.超级管理员 1.其他")
    private Integer type = 1;


    public static PageVO build(PageRRDTO pageRRDTO, List<?> list, Integer totalCount) {
        PageVO pageVO = new PageVO();

        pageVO.setPageSize(pageRRDTO.getLimit());
        pageVO.setData(list);
        pageVO.setTotalCount(totalCount);
        pageVO.setPageNo(pageRRDTO.getPage());
        pageVO.setTotalPage(totalCount != 0 ? (int)Math.ceil((double) pageVO.getTotalCount() / pageVO.getPageSize()) : 0);

        return pageVO;
    }
    public static PageVO build(PageDTO pageDTO, List<?> list, Integer totalCount) {
        PageVO pageVO = new PageVO();

        pageVO.setType(pageDTO.getType());
        pageVO.setPageSize(pageDTO.getPageSize());
        pageVO.setData(list);
        pageVO.setTotalCount(totalCount);
        pageVO.setPageNo(pageDTO.getPageNo());
        pageVO.setTotalPage(totalCount != 0 ? (int)Math.ceil((double) pageVO.getTotalCount() / pageVO.getPageSize()) : 0);

        return pageVO;
    }
}
