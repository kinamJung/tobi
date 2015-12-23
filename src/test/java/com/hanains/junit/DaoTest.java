package com.hanains.junit;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hanains.dao.UserDao;
import com.hanains.vo.UserVo;

import junit.framework.TestCase;
import static org.junit.Assert.assertThat;

import org.junit.Before;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
public class DaoTest  {
	
	
	private UserDao userdao;

	@Before
	public void setUp(){
		ApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		this.userdao = (UserDao)ctx.getBean("userdao");
	}
	
	@Test
	public void daoTest(){
	//ApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		
		
		
		UserVo vo = new UserVo();
		//vo.setNo(1L);
		vo.setEmail("도우너닷컴");
		
		UserVo user = userdao.get("도우너닷컴");
		
		assertNotEquals(userdao.get("도우너닷컴"), null);
	}
	
	@Test
	public void daoTestTwo(){
		
		
		UserVo vo = new UserVo();
		vo.setNo(1L);
		assertEquals(userdao.getPassword(vo), "1234");
		
	}
	
	
}
