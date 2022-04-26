package com.petcelsius.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class HeartDetailImage implements Serializable {
    private Long id;
    private Date create_time;
    private Date alter_time;
    private Boolean del_mark;

    // 对应petId
    private Long heart_id;
    private String img;
}
