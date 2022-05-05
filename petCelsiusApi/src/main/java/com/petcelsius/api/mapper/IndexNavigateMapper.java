package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.IndexNavigate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 首页导航栏mapper接口
 */
@Mapper
public interface IndexNavigateMapper extends BaseMapper<IndexNavigate> {
    List<IndexNavigate> selectNavigateToSix();
}
