package com.ssg.global.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ssg.global.dao.SampleDaoImpl;
import com.ssg.global.dto.SampleDto;



@Service
public class SampleService {
	
	@Autowired
	private SampleDaoImpl sampleDao;
	
	
	public String sampleService(Model model) throws Exception{
		SampleDto sampleDto = sampleDao.selectOne("38");
		model.addAttribute("subject", sampleDto.getSubject());
		model.addAttribute("content", sampleDto.getContent());
		return "Success";
	}
	
	
	public String sampleListService(Model model) throws Exception{
		List<HashMap<String, String>> list;
		list = sampleDao.selectList("All");
		model.addAttribute("listArray", list);
		return "Success";
	}
	
	
	public String sampleInsertService(Model model) throws Exception{
		
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("subject", "subject");
        param.put("content", "content");		
        sampleDao.insert(param);
		String lastInsertId =  param.get("sample_id").toString();
		model.addAttribute("lastInsertId", lastInsertId);
		
		return "Success";
	}	
	
	
}
