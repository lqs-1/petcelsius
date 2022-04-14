package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.IndexFloor;
import com.petcelsius.api.domain.IndexFloorImg;
import com.petcelsius.api.mapper.IndexFloorMapper;
import com.petcelsius.api.service.IndexFloorImgService;
import com.petcelsius.api.service.IndexFloorService;
import com.petcelsius.api.vo.IndexFloorVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("IndexFloorService")
public class IndexFloorServiceImpl extends ServiceImpl<IndexFloorMapper, IndexFloor> implements IndexFloorService {
    @Autowired
    private IndexFloorImgService indexFloorImgService;

    @Value("${oss.base.url}")
    private String ossBaseUrl;

    /**
     * 查询楼层信息
     * @return
     */
    @Override
    public List<IndexFloorVo> selectFloorToFour() {
        List<IndexFloor> indexFloors = this.baseMapper.selectFloorToFour();
        // 根据楼层id查询出对应的楼层的图片和详细内容
        List<IndexFloorVo> floorVos = indexFloors.stream().map(item -> {
            Long floorId = item.getId();
            // 查询楼层的图片和详细内容
            List<IndexFloorImg> indexFloorImgList = indexFloorImgService.selectByFloorId(floorId);

            // 处理图片链接
            String title_img = item.getTitle_img();
            String floor_index_img = item.getFloor_index_img();
            String real_title_img = ossBaseUrl + title_img;
            String real_floor_index_img = ossBaseUrl + floor_index_img;
            item.setFloor_index_img(real_floor_index_img);
            item.setTitle_img(real_title_img);
            // 拷贝属性
            IndexFloorVo indexFloorVo = new IndexFloorVo();
            BeanUtils.copyProperties(item, indexFloorVo);
            indexFloorVo.setIndexFloorImgList(indexFloorImgList);
            return indexFloorVo;
        }).collect(Collectors.toList());
        return floorVos;
    }
}
