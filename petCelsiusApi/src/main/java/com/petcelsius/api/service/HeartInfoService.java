package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.HeartInfo;
import com.petcelsius.api.vo.HeartListVo;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 缅怀信息service接口
 */
public interface HeartInfoService extends IService<HeartInfo> {
    List<HeartListVo> getHeartList();
}
