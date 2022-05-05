package com.petcelsius.api.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 首页楼层图片右边实体类
 */
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
