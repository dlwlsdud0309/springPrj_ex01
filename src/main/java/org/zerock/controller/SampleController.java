package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller //스프링의 객체로 등록
//servlet-context에 component-scan에서 controller 패키지 안의 어노테이션 @Controller가 추가된
//클래스들을 객체로 생성하여 관리하게함
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dataFormat, false));
//	}
	

	@RequestMapping("")
	public void basic() {
		log.info("basic.....................");
	}
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get...........................");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic get only get.....................");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		log.info(""+dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		log.info("name : "+name);
		log.info("age : "+age);
		
		return "ex02";
	}
	
	//동일한 이름의 파라미터가 여러 개 전달되는 경우
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids")ArrayList<String> ids) {
	//public @ResponseBody String ex02List(@RequestParam("ids")ArrayList<String> ids) {
	//위처럼 @ResponseBody를 추가했을 경우 화면에 오류 메세지, 그리고 데이터가 아니라 ex02List만 출력됨
	//이는 @ResponseBody가 VO 객체를 JSON으로 바꿔서 HTTP body에 담는 어노테이션이기 때문이다
		
		log.info("ids : "+ids);
		
		return "ex02List";
	}
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		
		log.info("array ids : "+Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	//여러 개의 객체 타입을 처리할 때
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		
		log.info("list dtos : "+list);
		
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo : "+todo);
		
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		
		log.info("dto : "+dto);
		log.info("page : "+page);
		
		return "/sample/ex04";
		
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("/ex05.................");
	}
	
	//리턴 타입을 복합적인 데이터가 들어간 객체 타입으로 지정하기 위해 jackson-databind 라이브러리 추가
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		
		log.info("/ex06.............");
		
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("홍길동");
		
		return dto;
	}
	
	//ResponseEntity
	//ResponseEntity는 HttpHeaders 객체를 같이 전달할 수 있고 이를 통해 HTTP 헤더 메세지를 가공하는 것이 가능하다
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		
		log.info("/ex07........");
		
		// {"name":"홍길동"}
		String msg = "{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders(); //org.springframework.http.HttpHeaders;
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
	@GetMapping("/exUpload")
	public void exUpload() {
		
		log.info("/exUpload....");
	
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		
		files.forEach(file -> {
			log.info("------------------------------");
			log.info("name : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			
		});
	}
}
