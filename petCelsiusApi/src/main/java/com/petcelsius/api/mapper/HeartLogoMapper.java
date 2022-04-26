package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.HeartLogo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HeartLogoMapper extends BaseMapper<HeartLogo> {
    HeartLogo selectByTitle(@Param("title") String title);

}
