package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.IndexBanner;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexBannerMapper extends BaseMapper<IndexBanner> {
    List<IndexBanner> selectBannerToFive();
}
