package com.eric.itracer.dao;

import java.util.Date;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.eric.itracer.dao.impl.UrlEnterDAO;
import com.eric.itracer.entity.embeded.Channel;
import com.eric.itracer.entity.embeded.CustomerInfo;
import com.eric.itracer.entity.embeded.HttpHeader;
import com.eric.itracer.entity.url.UrlEnter;

public class UrlEnterDAOTest {
	
	private UrlEnterDAO dao;
	
	@Before
	public void setup(){
		dao = new UrlEnterDAO();
	}
	
	@Test
	public void test_save_entity() {
		Channel mobileChannel = new Channel("mobile_bank", "samsung s3");
		CustomerInfo customer = new CustomerInfo("0911110", "127.0.0.1", true);
		HttpHeader header = new HttpHeader(
				"Mozilla/5.0 (X11; Linux i686) AppleWebKit/537.17 (KHTML, like Gecko) Ubuntu Chromium/24.0.1312.56 Chrome/24.0.1312.56 Safari/537.17",
				null, "text/javascript; charset=utf-8",
				"Fri, 15 Feb 2013 10:50:05 GMT", null, null,
				"http://0.136.web0.im.weibo.com/im", "hello", 200);
		UrlEnter entity = new UrlEnter(mobileChannel, customer, header,
				"http://0.136.web0.im.weibo.com/im", new Date());
		dao.save(entity);
		
		assertNotNull(entity.getId());
		assertNotEquals(0, entity.getId());
		UrlEnter entity_from_database = dao.get(entity.getId());
		assertEquals(entity.getChannel().getName(), entity_from_database.getChannel().getName());
	}
}
