package com.ienglish.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel(description = "申請 Token 的基本資料")
public class PersonalInfo implements Serializable {
    @ApiModelProperty(value = "名字", required = true)
    private String first_name;
    @ApiModelProperty(value = "姓氏", required = true)
    private String last_name;
    @ApiModelProperty(value = "手機號碼", required = true)
    private String msisdn;
    @ApiModelProperty(value = "電子信箱", required = true)
    private String email;
    @ApiModelProperty(value = "表單類別", required = true)
    private String form_type;
}
