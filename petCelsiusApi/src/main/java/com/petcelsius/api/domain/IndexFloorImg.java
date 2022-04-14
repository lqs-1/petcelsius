package com.petcelsius.api.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class IndexFloorImg extends BaseDomain implements Serializable {
    private Long id;
    private Date create_time;
    private Date alter_time;
    private Boolean del_mark;
    private String floor_img;
    private Long floor_id;
    private Long detail_id;
    private Long index;

    // 用于查询详情
    private IndexFloorDetail indexFloorDetail;
}
