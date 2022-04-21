package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.HeartInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HeartInfoMapper extends BaseMapper<HeartInfo> {
    List<HeartInfo> selectAll();
}
