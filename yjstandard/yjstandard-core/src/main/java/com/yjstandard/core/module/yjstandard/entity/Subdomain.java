package com.yjstandard.core.module.yjstandard.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author SuJianyong
 * @since 2020-08-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Subdomain implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 域名称
     */
    private String username;

    /**
     * 域密码
     */
    private String password;

    /**
     * 中文名称
     */
    @TableField("cnName")
    private String cnName;

    /**
     * 拼音缩写
     */
    @TableField("enName")
    private String enName;

    /**
     * 是否启用(是否显示在列表)
     */
    private String enabled;

    /**
     * 状态（on开启,off关闭）
     */
    private String state;

    /**
     * 更新时间
     */
    @TableField("updateTime")
    private Date updateTime;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private Date createTime;

    /**
     * 所属组ID
     */
    @TableField("groupId")
    private String groupId;

    /**
     * 排序号
     */
    @TableField("orderNumber")
    private Integer orderNumber;

    /**
     * 描述
     */
    @TableField("subDesc")
    private String subDesc;

    /**
     * 平台类型ID，来源字典表
     */
    @TableField("subTypeId")
    private String subTypeId;

    /**
     * 下级域的物理地址及端口
     */
    @TableField("subAddress")
    private String subAddress;

    /**
     * 所属本域
     */
    @TableField("belongRootdomain")
    private String belongRootdomain;

    /**
     * 子域经度
     */
    private String lng;

    /**
     * 子域纬度
     */
    private String lat;

    /**
     * 是否订阅
     */
    @TableField("isSubscribe")
    private String isSubscribe;

    /**
     * 视频默认播放地址
     */
    @TableField("videoUrl")
    private String videoUrl;

    /**
     * 是否28181
     */
    private String to28181;

    /**
     * 子域ID
     */
    @TableField("checkTime")
    private Date checkTime;


}
