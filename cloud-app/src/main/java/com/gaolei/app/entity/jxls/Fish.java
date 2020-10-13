package com.gaolei.app.entity.jxls;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author DuebassLei
 * @version 1.0
 * @date 2020/10/12 17:07
 */
@Data
@ApiModel("鱼基本信息")
public class Fish {
    /**
     * 名称
     * */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 价格
     **/
    @ApiModelProperty("价格")
    private String price;

    /**
     * 品种
     * */
    @ApiModelProperty("种类")
    private String kind;
}
