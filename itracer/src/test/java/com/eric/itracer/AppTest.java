package com.eric.itracer;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Unit test for simple App.
 */
public class AppTest {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	@Before
	public void setup() {
		Configuration config = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	@After
	public void tearDown() {
		sessionFactory.close();
	}
	
	@Test
	public void test_connection(){
		Session session = sessionFactory.openSession();
		assertTrue(session.isOpen());
	}
}
