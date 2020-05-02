package com.universe.starry.system.service.impl;

import com.universe.starry.system.entity.Log;
import com.universe.starry.system.mapper.LogMapper;
import com.universe.starry.system.service.LogService;
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
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
