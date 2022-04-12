package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexBanner;

import java.util.List;

public interface IndexBannerService extends IService<IndexBanner> {
    List<IndexBanner> selectBannerToFive();
}
