package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.CooperateDescImg;

import java.util.List;


public interface CooperateDescImgService extends IService<CooperateDescImg> {
    List<CooperateDescImg> selectListByCooperateId(Long cooperateId);
}
