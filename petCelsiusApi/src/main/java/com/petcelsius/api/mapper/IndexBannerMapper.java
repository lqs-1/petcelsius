package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.IndexBanner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 首页banner的mapper接口
 */
@Mapper
public interface IndexBannerMapper extends BaseMapper<IndexBanner> {
    List<IndexBanner> selectBannerToFive();
}
