package com.yunji.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @author: du
 * @Date: 2020/09/11 9:52
 * @Modified:
 **/

@Data
@TableName("u_demo")
@ApiModel(value="演示类" )
public class Demo {

    @ApiModelProperty(value = "记录id")
    @TableId("ID")
    private int id ;

    @ApiModelProperty(value = "用户id")
    private String userId ;

    @ApiModelProperty(value = "用户姓名")
    private String userName ;

    @ApiModelProperty(value = "用户地址")
    private String userAddress ;

    @ApiModelProperty(value = "用户手机号码")
    private String phone ;

    @ApiModelProperty(value = "新增时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime ;



}
