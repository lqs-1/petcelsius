package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexNavigate;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 首页导航service接口
 */
public interface IndexNavigateService extends IService<IndexNavigate> {
    List<IndexNavigate> selectNavigateToSix();
}
