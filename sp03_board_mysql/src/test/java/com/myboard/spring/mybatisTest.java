package com.myboard.spring;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class mybatisTest {
	//의존 주입(DI)
//	@Inject 
//	@Autowired
	@Resource
	private SqlSessionFactory sf;
	
	@Resource
	private SqlSession session;
	
	@Test
	public void test() {
//		System.out.println("팩토리:"+sf);
//		System.out.println("세션:" + session);
		
		Assert.assertNotNull(sf);
		Assert.assertNotNull(session);
		
		
		
	}

}
