package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.IndexFloorDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 首页楼层详情mapper接口
 */
@Mapper
public interface IndexFloorDetailMapper extends BaseMapper<IndexFloorDetail> {
    IndexFloorDetail findById(Long detail_id);
}
