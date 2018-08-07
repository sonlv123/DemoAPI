package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/test3")
	public ResponseEntity<String> getApi3() {
	String cd = new String("abcsedfdfd");
		return new ResponseEntity<>(cd,HttpStatus.OK);
	}
	
	@GetMapping("/test1")
	public ResponseEntity<Map<String,String>> getApi() {
		Map<String,String> a = new HashMap<String,String>();
		a.put("ja", "nihon");
		a.put("en", "eng");
		return new ResponseEntity<>(a,HttpStatus.OK);
	}
	
	@GetMapping("/test2")
	public ResponseEntity<List<Name>> getApi2() {
		List<Name> listName = new ArrayList<Name>();
		Name b = new Name();
		b.setName("Tuyen");
		b.setTuoi("28");
		listName.add(b);
		Name c = new Name();
		c.setName("Son");
		c.setTuoi("28");
		listName.add(c);
		return new ResponseEntity<>(listName,HttpStatus.OK);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<Name> insApi2(@RequestBody Name name) {
		System.out.println(name.getName());
		name.setName("new");
		name.setTuoi("30");
		return new ResponseEntity<>(name,HttpStatus.OK);
	}
}
