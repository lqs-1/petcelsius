package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.IndexFloor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexFloorMapper extends BaseMapper<IndexFloor> {
    List<IndexFloor> selectFloorToFour();
}
