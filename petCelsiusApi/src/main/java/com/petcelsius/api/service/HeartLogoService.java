package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.HeartLogo;

import java.util.List;

public interface HeartLogoService extends IService<HeartLogo> {
    // 暂时没用
    HeartLogo selectByTitle(String title);

    List<HeartLogo> selectAll();
}
