package com.petcelsius.api.vo;

import lombok.Data;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 9:11
 * @do : 封装缅怀页面展示数据
 */

@Data
public class HeartListVo {
    // TODO 继续完善
    private Long userId;
    private Long petId;
    private String topic;
    private String username;
    private String petname;
    private String title;
//    private String logo;
    private String petTopic;
    private String desc;
}
