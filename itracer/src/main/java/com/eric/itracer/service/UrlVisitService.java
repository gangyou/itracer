package com.eric.itracer.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.eric.itracer.dao.impl.UrlEnterDAO;
import com.eric.itracer.dao.impl.UrlExitDAO;
import com.eric.itracer.entity.embeded.HttpHeader;
import com.eric.itracer.entity.url.UrlEnter;
import com.eric.itracer.entity.url.UrlExit;
import com.eric.itracer.service.helper.JsonResult;
import com.eric.itracer.util.HttpHeadersUtil;

@Path("/url")
public class UrlVisitService extends LoggingService {

	private UrlEnterDAO urlEnterDAO;
	private UrlExitDAO urlExitDAO;

	public UrlVisitService() {
		urlEnterDAO = new UrlEnterDAO();
		urlExitDAO = new UrlExitDAO();
	}

	@POST
	@Path("/enter")
	@Produces("application/json")
	@Consumes("application/json")
	public JsonResult urlEnter(UrlEnter enter, @Context HttpHeaders httpHeaders) {
		JsonResult result = new JsonResult();
		try {
			HttpHeader header = HttpHeadersUtil.buildHttpHeader(httpHeaders);
			enter.setHttpHeader(header);
			urlEnterDAO.save(enter);
		} catch (Exception e) {
			err("存储UrlEnter实体失败: " + enter);
			result.setSuccess(false);
			result.setMsg("persistent Url Enter record error!");
			return result;
		}
		result.setSuccess(true);
		return result;
	}

	@POST
	@Path("/exit")
	@Produces("application/json")
	@Consumes("application/json")
	public JsonResult urlExit(UrlExit exit, @Context HttpHeaders httpHeaders) {
		JsonResult result = new JsonResult();
		try {
			HttpHeader header = HttpHeadersUtil.buildHttpHeader(httpHeaders);
			exit.setHttpHeader(header);
			urlExitDAO.save(exit);
		} catch (Exception e) {
			err("存储UrlExit实体失败: " + exit);
			result.setSuccess(false);
			result.setMsg("persistent Url exit record error!");
			return result;
		}
		result.setSuccess(true);
		return result;
	}

}
