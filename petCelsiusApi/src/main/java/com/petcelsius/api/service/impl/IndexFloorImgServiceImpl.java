package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.IndexFloorDetail;
import com.petcelsius.api.domain.IndexFloorImg;
import com.petcelsius.api.mapper.IndexFloorImgMapper;
import com.petcelsius.api.service.IndexFloorDetailService;
import com.petcelsius.api.service.IndexFloorImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("IndexFloorImgService")
public class IndexFloorImgServiceImpl extends ServiceImpl<IndexFloorImgMapper, IndexFloorImg> implements IndexFloorImgService {
    @Autowired
    private IndexFloorDetailService indexFloorDetailService;

    @Value("${oss.base.url}")
    private String ossBaseUrl;

    /**
     * 根据楼层基本信息的id查询出楼层对应的小图
     * @param floorId
     * @return
     */
    @Override
    public List<IndexFloorImg> selectByFloorId(Long floorId) {
        List<IndexFloorImg> indexFloorImgList = this.baseMapper.selectByFloorId(floorId);
        // 查出所有的图片之后，按照详情id查询所有详情
        List<IndexFloorImg> indexFloorImgs = indexFloorImgList.stream().map(item -> {
            Long detail_id = item.getDetail_id();
            IndexFloorDetail indexFloorDetail = indexFloorDetailService.selectById(detail_id);

            // 处理链接
            String floor_img = item.getFloor_img();
            String real_floor_img = ossBaseUrl + floor_img;
            item.setFloor_img(real_floor_img);

            // TODO 下面的语句未null，后面再实现
            item.setIndexFloorDetail(indexFloorDetail);
            return item;
        }).collect(Collectors.toList());
        return indexFloorImgs;
    }
}
