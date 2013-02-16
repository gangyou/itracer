package com.eric.itracer.service;

import java.io.Serializable;

public class JsonResult implements Serializable {
	private static final long serialVersionUID = -3179342434669068854L;
	private boolean result;
	private String msg;
	
	public JsonResult(boolean result, String msg) {
		super();
		this.result = result;
		this.msg = msg;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
