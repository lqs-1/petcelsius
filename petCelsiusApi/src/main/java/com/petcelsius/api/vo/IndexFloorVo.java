package com.petcelsius.api.vo;

import com.petcelsius.api.domain.IndexFloor;
import com.petcelsius.api.domain.IndexFloorImg;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class IndexFloorVo extends IndexFloor implements Serializable {
    // TODO 继续完善
    private List<IndexFloorImg> indexFloorImgList;
}
