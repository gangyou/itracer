package com.eric.itracer.service;

import java.io.Serializable;

public class JsonResult implements Serializable {
	private static final long serialVersionUID = -3179342434669068854L;
	private boolean success = false;
	private String msg = "";

	public JsonResult() {
	}

	public JsonResult(boolean success, String msg) {
		super();
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
