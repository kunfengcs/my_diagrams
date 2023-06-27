package com.yqg.manage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * @author suzhuang
 * @ClassName: role
 * @Function: TODO
 * @Date: 2023/5/6 16:11
 */

@Getter
@Setter
@TableName()
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role  implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("设备编号")
    private String equipNumber;

}

