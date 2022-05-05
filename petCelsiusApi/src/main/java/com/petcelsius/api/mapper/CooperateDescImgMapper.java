package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.CooperateDescImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 合作详情图片mapper接口
 */
@Mapper
public interface CooperateDescImgMapper extends BaseMapper<CooperateDescImg> {
    List<CooperateDescImg> selectListByCooperateId(@Param("cooperateId") Long cooperateId);
}
