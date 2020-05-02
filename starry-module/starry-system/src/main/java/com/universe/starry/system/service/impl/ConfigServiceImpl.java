package com.universe.starry.system.service.impl;

import com.universe.starry.system.entity.Config;
import com.universe.starry.system.mapper.ConfigMapper;
import com.universe.starry.system.service.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoutianxiang
 * @since 2020-05-01
 */
@Slf4j
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

}
