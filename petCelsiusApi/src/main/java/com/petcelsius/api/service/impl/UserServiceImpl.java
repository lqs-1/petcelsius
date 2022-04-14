package com.petcelsius.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.petcelsius.api.domain.User;
import com.petcelsius.api.mapper.UserMapper;
import com.petcelsius.api.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findByMobile(String mobile) {
        LambdaQueryWrapper<User> userQuery = new LambdaQueryWrapper<>();
        userQuery.eq(mobile != null && !mobile.equals(""), User::getMobile, mobile);
        User user = this.baseMapper.selectOne(userQuery);
        return user;
    }

    /**
     * 修改用户信息
     *
     * @param alterUser: 要修改的信息
     */
    @Override
    @Transactional
    public void updateByIdself(User alterUser) {
        this.baseMapper.alterByIdself(alterUser);
    }
}
