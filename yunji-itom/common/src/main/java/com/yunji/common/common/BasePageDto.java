package com.yunji.common.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @author: du
 * @Date: 2020/09/11 11:55
 * @Modified:
 **/
@Data
public class BasePageDto {

    @ApiModelProperty(value = "当前页")
    private long nowPage = 1  ;

    @ApiModelProperty(value = "分页大小")
    private long pageSize = 10  ;
}
