package com.petcelsius.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class IndexNavigate implements Serializable {
    private Long id;
    private Date create_time;
    private Date alter_time;
    private Boolean del_mark;
    private String title;
    private String icon;
    private Long index;

}
