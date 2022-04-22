package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.CooperateDescImg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CooperateDescImgMapper extends BaseMapper<CooperateDescImg> {
    List<CooperateDescImg> selectListByCooperateId(@Param("cooperateId") Long cooperateId);
}
