package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.CooperateInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CooperateInfoMapper extends BaseMapper<CooperateInfo> {
    List<CooperateInfo> selectAll();
}
