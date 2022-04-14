package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.IndexFloorImg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexFloorImgMapper extends BaseMapper<IndexFloorImg> {
    List<IndexFloorImg> selectByFloorId(Long floorId);
}
