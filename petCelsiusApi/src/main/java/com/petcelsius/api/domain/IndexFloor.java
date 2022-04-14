package com.petcelsius.api.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.Date;

@Data
public class IndexFloor extends BaseDomain implements Serializable {
    private Long id;
    private Date create_time;
    private Date alter_time;
    private Boolean del_mark;
    private String title;
    private String title_img;
    private String floor_index_img;
    private Long index;
}
