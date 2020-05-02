package com.universe.starry.system.controller;

import com.universe.starry.common.response.BasicController;
import com.universe.starry.common.response.Response;
import com.universe.starry.system.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/system/dictionary")
public class DictionaryController extends BasicController {

	@Autowired
	private DictionaryService dictionaryService;

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
