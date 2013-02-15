package com.eric.itracer.entity.embeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HttpHeader {

	@Column(name = "header_user_agent", nullable = false)
	private String userAgent;
	@Column(name = "header_cookie")
	private String cookie;
	@Column(name = "header_content_type")
	private String contentType;
	@Column(name = "header_date")
	private String date;
	@Column(name = "header_expect")
	private String expect;
	@Column(name = "header_from")
	private String from;
	@Column(name = "header_referer")
	private String referer;
	@Column(name = "header_x_request_with")
	private String xRequestedWith;
	@Column(name = "response_code", length = 3)
	private int responseCode;

	public HttpHeader(String userAgent, String cookie, String contentType,
			String date, String expect, String from, String referer,
			String xRequestedWith, int responseCode) {
		super();
		this.userAgent = userAgent;
		this.cookie = cookie;
		this.contentType = contentType;
		this.date = date;
		this.expect = expect;
		this.from = from;
		this.referer = referer;
		this.xRequestedWith = xRequestedWith;
		this.responseCode = responseCode;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getxRequestedWith() {
		return xRequestedWith;
	}

	public void setxRequestedWith(String xRequestedWith) {
		this.xRequestedWith = xRequestedWith;
	}

}
