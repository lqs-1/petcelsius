package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.IndexNavigate;
import com.petcelsius.api.mapper.IndexNavigateMapper;
import com.petcelsius.api.service.IndexNavigateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("IndexNavigateService")
public class IndexNavigateServiceImpl extends ServiceImpl<IndexNavigateMapper, IndexNavigate> implements IndexNavigateService {

    @Value("${oss.base.url}")
    private String ossBaseUrl;

    /**
     * 查找索引为前6的navigate
     * @return
     */
    @Override
    public List<IndexNavigate> selectNavigateToSix() {
        List<IndexNavigate> navigates = this.baseMapper.selectNavigateToSix();
        // 处理数据，icon地址补充完整
        List<IndexNavigate> navigateList = navigates.stream().map(item -> {
            String icon = item.getIcon();
            String realIcon = ossBaseUrl + icon;
            item.setIcon(realIcon);
            return item;
        }).collect(Collectors.toList());
        return navigateList;
    }
}
