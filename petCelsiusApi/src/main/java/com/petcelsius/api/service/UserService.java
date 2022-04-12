package com.petcelsius.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.petcelsius.api.domain.User;

public interface UserService extends IService<User> {
    User findByMobile(String mobile);

    void updateByIdself(User alterUser);
}
