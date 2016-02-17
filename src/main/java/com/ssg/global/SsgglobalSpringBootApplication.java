package com.ssg.global;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.ssg.global.filter.SampleFilter;

@SpringBootApplication
@MapperScan(value={"com.ssg.global"})
public class SsgglobalSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsgglobalSpringBootApplication.class, args);
	}
	
	//=================== DB 관련 설정  ======================//
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		Resource[] arrResource = new PathMatchingResourcePatternResolver()
	            .getResources("classpath:mappers/*.xml");
		sqlSessionFactoryBean.setMapperLocations(arrResource);

	      
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}	
	//=====================================================//	
	
	
	//=================== Filter 관련 설정  ===================//
	@Bean
	public FilterRegistrationBean someFiterRegistration(){
		
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(getFilter());
		registration.addUrlPatterns("/sample/filter/*");
		
		registration.setName("sampleFilter");
		return registration;
	}
	
	@Bean(name = "getFilter")
    public Filter getFilter() {
        return new SampleFilter();
    }
	//=====================================================//
}
