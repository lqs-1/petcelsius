package com.petcelsius.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.petcelsius.api.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 用户mapper接口
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    void alterByIdself(User alterUser);
}
