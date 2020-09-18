package com.yunji.xk.yjstandard.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SuJianyong
 * @since 2020-08-08
 */
@Data
@TableName("subdomain")
@ApiModel(value="子域类" )
public class Subdomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "子域id")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "子域域名")
    private String username;

    @ApiModelProperty(value = "子域密码")
    private String password;

    @ApiModelProperty(value = "子域中文名")
    @TableField(value = "cnName")
    private String cnName;

    @ApiModelProperty(value = "子域英文缩写")
    @TableField(value = "enName")
    private String enName;

    @ApiModelProperty(value = "是否启用(是否显示在列表)")
    private String enabled;

    @ApiModelProperty(value = "子域状态（on开启,off关闭）")
    private String state;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updateTime")
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "所属组ID")
    @TableField(value = "groupId")
    private String groupId;

    @ApiModelProperty(value = "排序号")
    @TableField(value = "orderNumber")
    private Integer orderNumber;

    @ApiModelProperty(value = "描述")
    @TableField(value = "subDesc")
    private String subDesc;

    @ApiModelProperty(value = "平台类型ID，来源字典表")
    @TableField(value = "subTypeId")
    private String subTypeId;

    @ApiModelProperty(value = "下级域的物理地址及端口")
    @TableField(value = "subAddress")
    private String subAddress;

    @ApiModelProperty(value = "所属本域")
    @TableField(value = "belongRootdomain")
    private String belongRootdomain;

    @ApiModelProperty(value = "子域经度")
    private String lng;

    @ApiModelProperty(value = "子域纬度")
    private String lat;

    @ApiModelProperty(value = "是否订阅")
    @TableField(value = "isSubscribe")
    private String isSubscribe;

    @ApiModelProperty(value = "视频默认播放地址")
    @TableField(value = "videoUrl")
    private String videoUrl;

    @ApiModelProperty(value = "是否28181")
    @TableField(value = "to28181")
    private String to28181;

    @ApiModelProperty(value = "视频质量检查时间")
    @TableField(value = "checkTime")
    private Date checkTime;


}
