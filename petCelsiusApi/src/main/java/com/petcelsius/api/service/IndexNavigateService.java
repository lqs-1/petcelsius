package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexNavigate;

import java.util.List;

public interface IndexNavigateService extends IService<IndexNavigate> {
    List<IndexNavigate> selectNavigateToSix();
}
