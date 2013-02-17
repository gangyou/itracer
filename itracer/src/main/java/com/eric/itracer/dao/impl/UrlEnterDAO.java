package com.eric.itracer.dao.impl;

import java.util.concurrent.ConcurrentLinkedQueue;

import com.eric.itracer.dao.GenericHibernateDao;
import com.eric.itracer.entity.url.UrlEnter;

public class UrlEnterDAO extends GenericHibernateDao<UrlEnter, Long> {
	
	private static ConcurrentLinkedQueue<UrlEnter> queue = new ConcurrentLinkedQueue<UrlEnter>();
	
	public void save(UrlEnter enter){
		queue.add(enter);
		synchronized (queue) {
			if(queue.size() == 20){
				startOperation();
				for(UrlEnter e: queue){
					session.save(e);
				}
				endOperation();
				queue.clear();
			}
		}
	}
}
