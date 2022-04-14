package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.IndexFloorDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IndexFloorDetailMapper extends BaseMapper<IndexFloorDetail> {
    IndexFloorDetail findById(Long detail_id);
}
