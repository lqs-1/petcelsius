package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.HeartInfo;
import com.petcelsius.api.domain.User;
import com.petcelsius.api.mapper.HeartInfoMapper;
import com.petcelsius.api.service.HeartInfoService;
import com.petcelsius.api.service.UserService;
import com.petcelsius.api.vo.HeartListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("HeartInfoService")
public class HeartInfoServiceImpl extends ServiceImpl<HeartInfoMapper, HeartInfo> implements HeartInfoService {

    @Autowired
    private UserService userService;

    /**
     * 获取宠物缅怀的所有信息
     * @return
     */
    @Override
    public List<HeartListVo> getHeartList() {
        List<HeartInfo> heartInfos = this.baseMapper.selectAll();
        // 获取
        List<HeartListVo> heartListVos = heartInfos.stream().map(item -> {
            Long user_id = item.getUser_id();
            User user = userService.getById(user_id);
            HeartListVo heartListVo = new HeartListVo();
            heartListVo.setUserId(user_id);
            heartListVo.setPetId(item.getId());
            heartListVo.setUsername(user.getUsername());
            heartListVo.setPetname(item.getName());
            heartListVo.setTopic(user.getTopic());
            heartListVo.setTitle(item.getTitle());
            return heartListVo;
        }).collect(Collectors.toList());
        return heartListVos;
    }
}
