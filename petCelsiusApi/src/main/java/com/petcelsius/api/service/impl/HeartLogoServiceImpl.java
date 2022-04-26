package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.HeartLogo;
import com.petcelsius.api.mapper.HeartLogoMapper;
import com.petcelsius.api.service.HeartLogoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("HeartLogoService")
public class HeartLogoServiceImpl extends ServiceImpl<HeartLogoMapper, HeartLogo> implements HeartLogoService {

    @Value("${oss.base.url}")
    private String ossBaseUrl;

    /**
     * 暂时没有用到
     * 根据标题分类查询对应logo信息
     * @param title
     * @return
     */
    @Override
    public HeartLogo selectByTitle(String title) {
        HeartLogo heartLogo = this.baseMapper.selectByTitle(title);
        return heartLogo;
    }

    /**
     * 查询所有的标题和logo
     * @return
     */
    @Override
    public List<HeartLogo> selectAll() {
        List<HeartLogo> heartLogoList = this.baseMapper.selectList(null);
        List<HeartLogo> logoList = heartLogoList.stream().map(item -> {
            String logo = item.getLogo();
            item.setLogo(ossBaseUrl + logo);
            return item;
        }).collect(Collectors.toList());
        return logoList;
    }
}
