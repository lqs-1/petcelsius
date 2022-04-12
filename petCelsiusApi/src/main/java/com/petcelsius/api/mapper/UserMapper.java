package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    void alterByIdself(User alterUser);
}
