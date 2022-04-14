package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexFloor;
import com.petcelsius.api.vo.IndexFloorVo;

import java.util.List;

public interface IndexFloorService extends IService<IndexFloor> {
    List<IndexFloorVo> selectFloorToFour();
}
