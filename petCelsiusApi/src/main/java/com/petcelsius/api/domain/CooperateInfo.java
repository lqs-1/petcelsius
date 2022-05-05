package com.petcelsius.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 合作信息实体类
 */
@Data
public class CooperateInfo implements Serializable {
    private Long id;
    private Date create_time;
    private Date alter_time;
    private Boolean del_mark;

    private String title;
    private String logo;
    private String contact;
    private String address;
    private String desc;
}
