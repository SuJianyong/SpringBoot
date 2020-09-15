package com.yunji.dto;

import com.yunji.common.common.BasePageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description:
 * @author: du
 * @Date: 2020/09/11 11:55
 * @Modified:
 **/
@Data
public class QueryDemoByPage extends BasePageDto {
    @ApiModelProperty(value = "用户id")
    private String userId ;

    @ApiModelProperty(value = "用户姓名")
    private String userName ;

    @ApiModelProperty(value = "用户地址")
    private String userAddress ;

}
