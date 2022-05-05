package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexBanner;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 首页banner的service接口
 */
public interface IndexBannerService extends IService<IndexBanner> {
    List<IndexBanner> selectBannerToFive();
}
