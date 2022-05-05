package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.HeartDetailImage;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 缅怀详情图片service接口
 */
public interface HeartDetailImageService extends IService<HeartDetailImage> {
    List<HeartDetailImage> selectByPetId(Long petId);
}
