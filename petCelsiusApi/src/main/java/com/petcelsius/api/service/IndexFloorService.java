package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexFloor;
import com.petcelsius.api.vo.IndexFloorVo;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 首页楼层基本信息service接口
 */
public interface IndexFloorService extends IService<IndexFloor> {
    List<IndexFloorVo> selectFloorToFour();
}
