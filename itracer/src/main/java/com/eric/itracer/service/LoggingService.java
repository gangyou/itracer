package com.eric.itracer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingService {

	private Logger logger = LoggerFactory.getLogger(UrlVisitService.class);

	protected LoggingService() {
		super();
	}
	
	protected void info(String msg){
		logger.info(msg);
	}
	
	protected void err(String msg){
		logger.error(msg);
	}
	
	protected void debug(String msg){
		logger.debug(msg);
	}
	
	protected void trace(String msg){
		logger.trace(msg);
	}
	
	protected void warn(String msg){
		logger.warn(msg);
	}

}