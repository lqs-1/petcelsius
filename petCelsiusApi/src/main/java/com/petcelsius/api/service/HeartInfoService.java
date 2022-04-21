package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.HeartInfo;
import com.petcelsius.api.vo.HeartListVo;

import java.util.List;

public interface HeartInfoService extends IService<HeartInfo> {
    List<HeartListVo> getHeartList();
}
