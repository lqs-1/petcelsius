package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.CooperateDescImg;

import java.util.List;
/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 合作描述图片service接口
 */

public interface CooperateDescImgService extends IService<CooperateDescImg> {
    List<CooperateDescImg> selectListByCooperateId(Long cooperateId);
}
