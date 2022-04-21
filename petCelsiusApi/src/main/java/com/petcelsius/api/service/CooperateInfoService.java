package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.CooperateInfo;

import java.util.List;


public interface CooperateInfoService extends IService<CooperateInfo> {
    List<CooperateInfo> selectAll();
}
