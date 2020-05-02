package com.universe.starry.system.controller;

import com.universe.starry.common.response.BasicController;
import com.universe.starry.common.response.Response;
import com.universe.starry.system.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/system/cache")
public class CacheController extends BasicController {

	@Autowired
	private CacheService cacheService;
	
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public Response clear(){
    	cacheService.clearCache();
        return success();
    }
}
