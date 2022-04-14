package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.IndexNavigate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexNavigateMapper extends BaseMapper<IndexNavigate> {
    List<IndexNavigate> selectNavigateToSix();
}