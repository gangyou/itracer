package com.eric.itracer.util;

import java.util.List;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import com.eric.itracer.entity.embeded.HttpHeader;

public class HttpHeadersUtil {
	public static HttpHeader buildHttpHeader(HttpHeaders headers) {
		MultivaluedMap<String, String> requestHeaders = headers
				.getRequestHeaders();
		String userAgent = requestHeaders.getFirst(HttpHeaders.USER_AGENT);
		String cookie = requestHeaders.getFirst(HttpHeaders.COOKIE);
		String contentType = requestHeaders.getFirst(HttpHeaders.CONTENT_TYPE);
		String date = requestHeaders.getFirst(HttpHeaders.DATE);
		String expect = requestHeaders.getFirst(HttpHeaders.ETAG);
		String from = requestHeaders.getFirst(HttpHeaders.LOCATION);
		String referer = concateStringList(headers.getRequestHeader("Referer"));
		String xRequestedWith = concateStringList(headers
				.getRequestHeader("X-Requested-With"));
		int responseCode = 200;

		HttpHeader entity = new HttpHeader(userAgent, cookie, contentType,
				date, expect, from, referer, xRequestedWith, responseCode);

		return entity;
	}

	private static String concateStringList(List<String> list) {
		if (list == null || list.size() == 0)
			return "";
		StringBuffer result = new StringBuffer();
		for (String s : list) {
			result.append(s);
		}
		return result.toString();
	}

}
