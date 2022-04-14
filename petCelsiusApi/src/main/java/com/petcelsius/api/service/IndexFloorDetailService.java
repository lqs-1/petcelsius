package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexFloorDetail;

public interface IndexFloorDetailService extends IService<IndexFloorDetail> {
    IndexFloorDetail selectById(Long detail_id);
}
