package com.universe.starry.base.controller;

import com.universe.starry.base.service.RoleService;
import com.universe.starry.common.response.BasicController;
import com.universe.starry.common.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/base/role")
public class RoleController extends BasicController {

    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/save")
    public Response save(){
        return success();
    }

    @PutMapping(value = "/update")
    public Response update(){
        return success();
    }

    @DeleteMapping(value = "/delete")
    public Response delete(){
        return success();
    }

    @GetMapping(value = "/page")
    public Response page(){
        return success();
    }

    @GetMapping(value = "/detail")
    public Response detail(){
        return success();
    }
}
