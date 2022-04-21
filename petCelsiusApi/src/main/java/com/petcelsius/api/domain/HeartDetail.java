package com.petcelsius.api.domain;

import java.io.Serializable;
import java.util.Date;

public class HeartDetail implements Serializable {
    private Long id;
    private Date create_time;
    private Date alter_time;
    private Boolean del_mark;

    private String name;
}
