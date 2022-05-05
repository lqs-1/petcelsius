package com.petcelsius.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 缅怀信息实体类
 */
@Data
public class HeartInfo implements Serializable {
    private Long id;
    private Date create_time;
    private Date alter_time;
    private Boolean del_mark;

    private String title;
    private String name;
    private Long age;
    private String color;
    private String desc;
    private Long user_id;
    private Long detail_id;
    private String pet_topic;
}
