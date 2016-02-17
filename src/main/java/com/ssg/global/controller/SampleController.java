package com.ssg.global.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssg.global.service.SampleService;

@Controller
public class SampleController {

	@Autowired
	private SampleService sampleService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping("/")
	public String index() throws Exception{
		return "index";
	}
	
	//=================== view test  ======================//
	@RequestMapping("/sample/hello")
	public String hello(Model model) {
		model.addAttribute("name", "This is sample!!!!");
		return "/sample/hello";
	}
	//=====================================================//	
	
	
	//=================== DAO test  =======================//
	@RequestMapping("/sample/dao/sample")
	public String sample(Model model) throws Exception{
		sampleService.sampleService(model);
		return "/sample/dao/sample";
	}
	
	@RequestMapping("/sample/dao/sampleList")
	public String sampleList(Model model) throws Exception{
		sampleService.sampleListService(model);
		return "/sample/dao/sampleList";
	}
	
	@RequestMapping("/sample/dao/sampleInsert")
	public String sampleInsert(Model model) throws Exception{
		sampleService.sampleInsertService(model);
		return "/sample/dao/sampleInsert";
	}
	//=====================================================//	
	
	
	//=================== Filter test  ====================//
	@RequestMapping(value="/sample/filter/filter", method=RequestMethod.GET)
	public void filterGet(Model model) throws Exception{
		model.addAttribute("msg", "This is Filter GET test.");
	}	
	
	@RequestMapping(value="/sample/filter/filterPrc", method=RequestMethod.POST)
	public void filterPost(String id, String name, String filterValue, Model model) throws Exception{
		System.out.println("ID : " + id);
		System.out.println("NAME : " + name);
		System.out.println("filterValue : " + filterValue);
		
		model.addAttribute("msg", "This is Filter POST test.");
		model.addAttribute("id", id);
		model.addAttribute("name", name);
	}	
	//=====================================================//
	
	
	//=================== Interceptor test  ===============//
	@RequestMapping("/sample/interceptor/interceptor")
	public void interceptor(){
		
	}
	//=====================================================//
	
	
	//=================== Interceptor test  ===============//
	@RequestMapping("/sample/logging/logging")
	public void loggingTest(){
	    
	    log.trace("=========================trace level=======================");
	    log.debug("=========================debug level=======================");
	    log.info("=========================info level=======================");
	    log.warn("=========================warn level=======================");
	    log.error("=========================error level=======================");	    
	    
	}
	//=====================================================//
	
	
}
