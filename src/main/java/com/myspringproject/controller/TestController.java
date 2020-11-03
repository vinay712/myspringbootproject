package com.myspringproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myspringproject.controllermodel.ResponseModel;
import com.myspringproject.utilities.ResponseEntities;

@CrossOrigin
@RestController
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {
	@GetMapping(value = "/get")
	public ResponseEntity<ResponseModel> getData(HttpServletRequest request,
			@RequestParam(value = "param", required = true) String param) throws Exception {

		return ResponseEntities.generateResponseEntity(request, param);
	}

	@PostMapping(value = "/post")
	public ResponseEntity<ResponseModel> postData(HttpServletRequest request,
			@RequestBody(required = true) String param) throws Exception {

		return ResponseEntities.generateResponseEntity(request, param);
	}
}
