package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.IndexFloorDetail;
import com.petcelsius.api.mapper.IndexFloorDetailMapper;
import com.petcelsius.api.service.IndexFloorDetailService;
import org.springframework.stereotype.Service;

@Service("IndexFloorDetailService")
public class IndexFloorDetailServiceImpl extends ServiceImpl<IndexFloorDetailMapper, IndexFloorDetail> implements IndexFloorDetailService {
    @Override
    public IndexFloorDetail selectById(Long detail_id) {
        IndexFloorDetail indexFloorDetail = this.getBaseMapper().findById(detail_id);
        return indexFloorDetail;
    }
}
