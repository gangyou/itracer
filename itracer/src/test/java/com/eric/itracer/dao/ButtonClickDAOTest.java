package com.eric.itracer.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.eric.itracer.dao.impl.ButtonClickDAO;
import com.eric.itracer.entity.click.ButtonClick;
import com.eric.itracer.entity.embeded.Channel;
import com.eric.itracer.entity.embeded.ClickAction;
import com.eric.itracer.entity.embeded.CustomerInfo;

public class ButtonClickDAOTest {
	private ButtonClickDAO dao;
	
	@Before
	public void setup(){
		dao = new ButtonClickDAO();
	}
	
	@Test
	public void test_save_entity(){
		Channel mobileChannel = new Channel("mobile_bank", "samsung s3");
		CustomerInfo customer = new CustomerInfo("0911110", "127.0.0.1", true);
		ClickAction action = new ClickAction("http://localhost", new Date(), customer);
		ButtonClick entity = new ButtonClick("submit_btn", 
				"submit", "submit", "cls_submit", action, mobileChannel);
		dao.save(entity);
		
		assertNotNull(entity.getId());
		assertNotEquals(0, entity.getId());
		ButtonClick entity_from_database = dao.get(entity.getId());
		assertEquals(entity.getChannel().getName(), entity_from_database.getChannel().getName());
	}
}
