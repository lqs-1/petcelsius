package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.HeartInfo;
import com.petcelsius.api.domain.HeartLogo;
import com.petcelsius.api.domain.User;
import com.petcelsius.api.mapper.HeartInfoMapper;
import com.petcelsius.api.service.HeartInfoService;
import com.petcelsius.api.service.HeartLogoService;
import com.petcelsius.api.service.UserService;
import com.petcelsius.api.vo.HeartListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("HeartInfoService")
public class HeartInfoServiceImpl extends ServiceImpl<HeartInfoMapper, HeartInfo> implements HeartInfoService {

    @Autowired
    private UserService userService;

    @Value("${oss.base.url}")
    private String ossBaseUrl;

    /**
     * 获取宠物缅怀的所有信息
     * @return
     */
    @Override
    public List<HeartListVo> getHeartList() {
        List<HeartInfo> heartInfos = this.baseMapper.selectAll();
        // 获取
        List<HeartListVo> heartListVos = heartInfos.stream().map(item -> {
            // 根据用户id查询用户信息
            Long user_id = item.getUser_id();
            User user = userService.getById(user_id);
            // 根据标题分类查询对应logo
//            String title = item.getTitle();
//            HeartLogo heartLogo = heartLogoService.selectByTitle(title);
//            String logo = heartLogo.getLogo();
//            String realLogo = ossUrl + logo;
//            heartLogo.setLogo(realLogo);

            // TODO 详情信息

            String pet_topic = item.getPet_topic();
            String realPetTopic = ossBaseUrl + pet_topic;

            HeartListVo heartListVo = new HeartListVo();
            heartListVo.setUserId(user_id);
            heartListVo.setPetId(item.getId());
            heartListVo.setUsername(user.getUsername());
            heartListVo.setPetname(item.getName());
//            heartListVo.setLogo(heartLogo.getLogo());
            heartListVo.setTopic(user.getTopic());
            heartListVo.setTitle(item.getTitle());
            heartListVo.setPetTopic(realPetTopic);
            heartListVo.setDesc(item.getDesc());
            return heartListVo;
        }).collect(Collectors.toList());
        return heartListVos;
    }
}
