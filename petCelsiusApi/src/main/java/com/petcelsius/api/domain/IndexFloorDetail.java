package com.petcelsius.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class IndexFloorDetail extends BaseDomain implements Serializable {
    /*
    * 占位
    * */
    private Long id;
    private Date create_time;
    private Date alter_time;
    private Boolean del_mark;
    private String name;
}
