package com.eric.itracer.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.eric.itracer.dao.impl.HyperlinkClickDAO;
import com.eric.itracer.entity.click.HyperlinkClick;
import com.eric.itracer.service.helper.JsonResult;

@Path("/click")
public class HyperlinkClickService extends LoggingService {

	private HyperlinkClickDAO dao;

	public HyperlinkClickService() {
		dao = new HyperlinkClickDAO();
	}

	@Path("/link")
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public JsonResult service(HyperlinkClick click) {
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
