package com.universe.starry.base.controller;

import com.universe.starry.base.service.RolePermissionService;
import com.universe.starry.common.response.BasicController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoutianxiang
 * @since 2020-05-01
 */
@Slf4j
@RestController
@RequestMapping("/base/rolePermission")
public class RolePermissionController extends BasicController {

    @Autowired
    private RolePermissionService rolePermissionService;

}
