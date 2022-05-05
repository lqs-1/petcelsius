package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.CooperateInfo;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 合作信息service接口
 */
public interface CooperateInfoService extends IService<CooperateInfo> {
    List<CooperateInfo> selectAll();
}
