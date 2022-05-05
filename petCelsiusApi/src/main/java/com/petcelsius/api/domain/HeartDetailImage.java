package com.petcelsius.api.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 缅怀详情图片实体类
 */
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
