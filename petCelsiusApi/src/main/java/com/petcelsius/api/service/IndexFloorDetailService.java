package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.IndexFloorDetail;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 首页楼层的详情service接口
 */
// TODO 并未实现
public interface IndexFloorDetailService extends IService<IndexFloorDetail> {
    IndexFloorDetail selectById(Long detail_id);
}
