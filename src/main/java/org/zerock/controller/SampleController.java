package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller //스프링의 객체로 등록
//servlet-context에 component-scan에서 controller 패키지 안의 어노테이션 @Controller가 추가된
//클래스들을 객체로 생성하여 관리하게함
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	@RequestMapping("")
	public void basic() {
		log.info("basic.....................");
	}
}
