package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.HeartLogo;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 缅怀类型service接口
 */
public interface HeartLogoService extends IService<HeartLogo> {
    // 暂时没用
    HeartLogo selectByTitle(String title);

    List<HeartLogo> selectAll();
}
