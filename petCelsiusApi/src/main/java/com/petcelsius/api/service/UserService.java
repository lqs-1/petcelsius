package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.User;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 用户service接口
 */
public interface UserService extends IService<User> {
    User findByMobile(String mobile);

    void updateByIdself(User alterUser);
}
