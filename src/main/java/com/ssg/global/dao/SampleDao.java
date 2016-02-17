package com.ssg.global.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ssg.global.dto.SampleDto;

public interface SampleDao {
	public int insert(HashMap<String, Object> testColumn) throws Exception;
	public SampleDto selectOne(String testColumn) throws Exception;
	public List<HashMap<String, String>> selectList(String testColumn) throws Exception;
}
