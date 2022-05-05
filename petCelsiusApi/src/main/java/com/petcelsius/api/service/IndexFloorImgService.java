package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexFloorImg;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 首页楼层图片右边service接口
 */
public interface IndexFloorImgService extends IService<IndexFloorImg> {
    List<IndexFloorImg> selectByFloorId(Long floorId);
}
