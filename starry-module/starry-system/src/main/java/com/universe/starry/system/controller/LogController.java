package com.universe.starry.system.controller;

import com.universe.starry.common.response.BasicController;
import com.universe.starry.common.response.Response;
import com.universe.starry.system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/system/log")
public class LogController extends BasicController {

    @Autowired
    private LogService logService;

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
