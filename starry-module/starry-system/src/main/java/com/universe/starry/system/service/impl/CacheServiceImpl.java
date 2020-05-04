package com.universe.starry.system.service.impl;

import com.universe.starry.common.util.RedisUtil;
import com.universe.starry.system.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CacheServiceImpl implements CacheService {

	@Override
	public void clearCache() {
		System.out.println(RedisUtil.get("123"));
	}
}
