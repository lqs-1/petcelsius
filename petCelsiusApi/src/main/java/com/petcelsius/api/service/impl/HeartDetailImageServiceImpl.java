package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.HeartDetailImage;
import com.petcelsius.api.mapper.HeartDetailImageMapper;
import com.petcelsius.api.service.HeartDetailImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 接口实现
 */
@Service("HeartDetailImageService")
public class HeartDetailImageServiceImpl extends ServiceImpl<HeartDetailImageMapper, HeartDetailImage> implements HeartDetailImageService {

    @Value("${oss.base.url}")
    private String ossBaseUrl;

    /**
     * 获取对应详情项的图片
     * @param petId
     * @return
     */
    @Override
    public List<HeartDetailImage> selectByPetId(Long petId) {
        List<HeartDetailImage> heartDetailImageList = this.baseMapper.selectByPetId(petId);

        List<HeartDetailImage> heartDetailImages = heartDetailImageList.stream().map(item -> {
            String img = item.getImg();
//            String real_img = ossBaseUrl + img;
            item.setImg(ossBaseUrl + img);
            return item;
        }).collect(Collectors.toList());
        return heartDetailImages;
    }
}
