package com.eric.itracer.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.eric.itracer.dao.impl.ButtonClickDAO;
import com.eric.itracer.entity.click.ButtonClick;
import com.eric.itracer.service.helper.JsonResult;

@Path("/click")
public class ButtonClickService extends LoggingService {
	private ButtonClickDAO dao;

	public ButtonClickService() {
		dao = new ButtonClickDAO();
	}

	@POST
	@Path("/button")
	@Consumes("application/json")
	@Produces("application/json")
	public JsonResult service(ButtonClick click) {
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
