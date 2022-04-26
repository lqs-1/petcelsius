package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.HeartDetailImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HeartDetailImageMapper extends BaseMapper<HeartDetailImage> {
    List<HeartDetailImage> selectByPetId(@Param("petId") Long petId);
}
