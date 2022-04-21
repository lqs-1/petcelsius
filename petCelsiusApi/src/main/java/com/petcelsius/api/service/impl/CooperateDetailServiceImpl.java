package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.CooperateDetail;
import com.petcelsius.api.mapper.CooperateDetailMapper;
import com.petcelsius.api.service.CooperateDetailService;
import org.springframework.stereotype.Service;

@Service("CooperateDetailService")
public class CooperateDetailServiceImpl extends ServiceImpl<CooperateDetailMapper, CooperateDetail> implements CooperateDetailService {
}
