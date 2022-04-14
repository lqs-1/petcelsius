package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexFloorImg;

import java.util.List;

public interface IndexFloorImgService extends IService<IndexFloorImg> {
    List<IndexFloorImg> selectByFloorId(Long floorId);
}
