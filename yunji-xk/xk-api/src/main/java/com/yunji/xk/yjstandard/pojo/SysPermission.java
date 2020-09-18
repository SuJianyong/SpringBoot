package com.yunji.xk.yjstandard.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 后台权限表
 * </p>
 *
 * @author sujy
 * @since 2020-09-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SysPermission对象", description="后台权限表")
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自定id,主要供前端展示权限列表分类排序使用.")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "归属菜单,前端判断并展示菜单使用,")
    private String menuCode;

    @ApiModelProperty(value = "菜单的中文释义")
    private String menuName;

    @ApiModelProperty(value = "权限的代码/通配符,对应代码中@RequiresPermissions 的value")
    private String permissionCode;

    @ApiModelProperty(value = "本权限的中文释义")
    private String permissionName;

    @ApiModelProperty(value = "是否本菜单必选权限, 1.必选 2非必选 通常是列表权限是必选")
    private Boolean requiredPermission;


}
