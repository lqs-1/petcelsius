package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.IndexBanner;
import com.petcelsius.api.mapper.IndexBannerMapper;
import com.petcelsius.api.service.IndexBannerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 接口实现
 */
@Service("IndexBannerService")
public class IndexBannerServiceImpl extends ServiceImpl<IndexBannerMapper, IndexBanner> implements IndexBannerService {


    @Value("${oss.base.url}")
    private String ossBaseUrl;

    /**
     * 查找索引为前五的banner
     * @return
     */
    @Override
    public List<IndexBanner> selectBannerToFive() {



        List<IndexBanner> indexBanners = this.baseMapper.selectBannerToFive();
        // 处理数据，image地址补充完整
        List<IndexBanner> realBannerList = indexBanners.stream().map(item -> {
            String image = item.getImage();
            String realImage = ossBaseUrl + image;
            item.setImage(realImage);
            return item;
        }).collect(Collectors.toList());
        return realBannerList;
    }
}
