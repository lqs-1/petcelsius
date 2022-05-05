package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.HeartLogo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 缅怀类型mapper接口
 */
@Mapper
public interface HeartLogoMapper extends BaseMapper<HeartLogo> {
    HeartLogo selectByTitle(@Param("title") String title);

}
