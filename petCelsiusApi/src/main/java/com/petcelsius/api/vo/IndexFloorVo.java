package com.petcelsius.api.vo;

import com.petcelsius.api.domain.IndexFloor;
import com.petcelsius.api.domain.IndexFloorImg;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 9:11
 * @do : 封装首页楼层展示数据
 */
@Data
public class IndexFloorVo extends IndexFloor implements Serializable {
    // TODO 继续完善
    private List<IndexFloorImg> indexFloorImgList;
}
