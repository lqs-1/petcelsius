package com.petcelsius.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
}
