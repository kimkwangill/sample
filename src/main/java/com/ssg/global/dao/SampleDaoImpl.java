package com.ssg.global.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssg.global.dto.SampleDto;

@Repository
public class SampleDaoImpl implements SampleDao {

	@Autowired
    private SqlSession sqlSession;	
	
	@Override
	public int insert(HashMap<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
        System.out.println(sqlSession.insert("sample.insert", param));
        
		return 1;
	}

	@Override
	public SampleDto selectOne(String sampleId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("sample.selectOne", sampleId);
	}

	@Override
	public List<HashMap<String, String>> selectList(String sampleId) throws Exception {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> resultSet = sqlSession.selectList("sample.selectList", sampleId);
        return resultSet;	
	}

}
