package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.HeartDetailImage;

import java.util.List;

public interface HeartDetailImageService extends IService<HeartDetailImage> {
    List<HeartDetailImage> selectByPetId(Long petId);
}
