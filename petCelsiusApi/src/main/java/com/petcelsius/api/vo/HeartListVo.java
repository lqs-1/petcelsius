package com.petcelsius.api.vo;

import com.petcelsius.api.domain.HeartInfo;
import lombok.Data;

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
