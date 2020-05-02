package com.universe.starry.base.service.impl;

import com.universe.starry.base.entity.User;
import com.universe.starry.base.mapper.UserMapper;
import com.universe.starry.base.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoutianxiang
 * @since 2020-05-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
