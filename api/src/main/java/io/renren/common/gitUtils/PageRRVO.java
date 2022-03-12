package io.renren.common.gitUtils;

import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRRVO {


    @ApiParam(value = "当前页数")
    private Integer currPage;

    @ApiParam(value = "列表数据")
    private List<?> list;

    @ApiParam(value = "每页记录数")
    private Integer pageSize;

    @ApiParam(value = "总记录数")
    private Integer totalCount;

    @ApiParam(value = "总页数")
    private Integer totalPage;

    @ApiParam(value = "类型 0.超级管理员 1.其他")
    private Integer type = 1;


    public static PageRRVO build(PageRRDTO pageRRDTO, List<?> list, Integer totalCount) {
        PageRRVO pageVO = new PageRRVO();

        pageVO.setPageSize(pageRRDTO.getLimit());
        pageVO.setList(list);
        pageVO.setTotalCount(totalCount);
        pageVO.setCurrPage(pageRRDTO.getPage());
        pageVO.setTotalPage(totalCount != 0 ? (int)Math.ceil((double) pageVO.getTotalCount() / pageVO.getPageSize()) : 0);

        return pageVO;
    }
    public static PageRRVO build(PageDTO pageDTO, List<?> list, Integer totalCount) {
        PageRRVO pageVO = new PageRRVO();

        pageVO.setType(pageDTO.getType());
        pageVO.setPageSize(pageDTO.getPageSize());
        pageVO.setList(list);
        pageVO.setTotalCount(totalCount);
        pageVO.setCurrPage(pageDTO.getPageNo());
        pageVO.setTotalPage(totalCount != 0 ? (int)Math.ceil((double) pageVO.getTotalCount() / pageVO.getPageSize()) : 0);

        return pageVO;
    }
}
