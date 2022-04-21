package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.HeartDetail;
import com.petcelsius.api.mapper.HeartDetailMapper;
import com.petcelsius.api.service.HeartDetailService;
import org.springframework.stereotype.Service;

@Service("HeartDetailService")
public class HeartDetailServiceImpl extends ServiceImpl<HeartDetailMapper, HeartDetail> implements HeartDetailService {
}
