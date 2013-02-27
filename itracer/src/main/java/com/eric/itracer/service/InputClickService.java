package com.eric.itracer.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.eric.itracer.dao.impl.InputClickDAO;
import com.eric.itracer.entity.click.InputClick;
import com.eric.itracer.service.helper.JsonResult;

@Path("/click")
public class InputClickService extends LoggingService {
	private InputClickDAO dao;
	
	public InputClickService() {
		dao = new InputClickDAO();
	}
	
	@POST
	@Path("/input")
	@Produces("application/json")
	@Consumes("application/json")
	public JsonResult service(InputClick click){
		JsonResult result = new JsonResult();
		try {
			dao.saveOrUpdate(click);
		} catch (Exception e) {
			err("save " + click + " error!!!");
			result.setSuccess(false);
			result.setMsg("save " + click + " error!!!");
			return result;
		}
		result.setSuccess(true);
		return result;
	}
}
