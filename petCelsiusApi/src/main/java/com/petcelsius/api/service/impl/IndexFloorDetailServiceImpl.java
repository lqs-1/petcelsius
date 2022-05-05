package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.IndexFloorDetail;
import com.petcelsius.api.mapper.IndexFloorDetailMapper;
import com.petcelsius.api.service.IndexFloorDetailService;
import org.springframework.stereotype.Service;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 接口实现
 */
@Service("IndexFloorDetailService")
public class IndexFloorDetailServiceImpl extends ServiceImpl<IndexFloorDetailMapper, IndexFloorDetail> implements IndexFloorDetailService {

    /**
     * 根据每个楼层右边的图片，点击查出对应详情信息
     * 当前未实现
     * @param detail_id
     * @return
     */
    @Override
    public IndexFloorDetail selectById(Long detail_id) {
        // TODO 未实现楼层点击跳转查询
        IndexFloorDetail indexFloorDetail = this.getBaseMapper().findById(detail_id);
        return indexFloorDetail;
    }
}
