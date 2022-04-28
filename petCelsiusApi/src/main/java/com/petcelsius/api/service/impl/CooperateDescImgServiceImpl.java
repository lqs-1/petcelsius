package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.CooperateDescImg;
import com.petcelsius.api.mapper.CooperateDescImgMapper;
import com.petcelsius.api.service.CooperateDescImgService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("CooperateDescImgService")
public class CooperateDescImgServiceImpl extends ServiceImpl<CooperateDescImgMapper, CooperateDescImg> implements CooperateDescImgService {

    @Value("${oss.base.url}")
    private String ossBaseUrl;


    /**
     * 根据合作机构基本信息的id来查询对应的详情图片
     * @param cooperateId
     * @return
     */
    @Override
    public List<CooperateDescImg> selectListByCooperateId(Long cooperateId) {
        List<CooperateDescImg> cooperateDescImgList = this.baseMapper.selectListByCooperateId(cooperateId);
        List<CooperateDescImg> cooperateDescImgs = cooperateDescImgList.stream().map(item -> {
            String desc_img = item.getDesc_img();
            String real_desc_img = ossBaseUrl + desc_img;
            item.setDesc_img(real_desc_img);
            return item;
        }).collect(Collectors.toList());
        return cooperateDescImgs;
    }
}
