package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.CooperateInfo;
import com.petcelsius.api.mapper.CooperateInfoMapper;
import com.petcelsius.api.service.CooperateInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("CooperateInfoService")
public class CooperateInfoServiceImpl extends ServiceImpl<CooperateInfoMapper, CooperateInfo> implements CooperateInfoService {

    @Value("${oss.base.url}")
    private String ossBaseUrl;

    @Override
    public List<CooperateInfo> selectAll() {
        List<CooperateInfo> cooperateInfos = this.baseMapper.selectAll();
        List<CooperateInfo> cooperateInfoList = cooperateInfos.stream().map(item -> {
            String logo = item.getLogo();
            String realLogo = ossBaseUrl + logo;
            item.setLogo(realLogo);
            return item;
        }).collect(Collectors.toList());
        return cooperateInfoList;
    }
}
