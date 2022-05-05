package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.HeartInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 缅怀信息mapper接口
 */
@Mapper
public interface HeartInfoMapper extends BaseMapper<HeartInfo> {
    List<HeartInfo> selectAll();
}
