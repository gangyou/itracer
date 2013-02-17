package com.eric.itracer.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UrlVisitServiceTest {

	private ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test
	public void test_post_url_enter_happy_path() throws Exception {
		String url = "http://localhost:8080/rest/url/enter";
		String contentType = "application/json";
		String filePath = "src/test/resources/url_enter.json";
		ClientRequest request = buildUrlEnterRequest(url, contentType, filePath);

		ClientResponse<String> response = request.post(String.class);

		assertNotNull(response);
		JsonResult result = deserilizeJsonResult(response);
		assertNotNull(result);
		assertTrue(result.isSuccess());
	}

	@Test
	public void test_post_url_exit_happy_path() throws Exception {
		String url = "http://localhost:8080/rest/url/exit";
		String contentType = "application/json";
		String filePath = "src/test/resources/url_exit.json";

		ClientRequest request = buildUrlEnterRequest(url, contentType, filePath);

		ClientResponse<String> response = request.post(String.class);

		assertNotNull(response);
		JsonResult result = deserilizeJsonResult(response);
		assertNotNull(result);
		assertTrue(result.isSuccess());
	}
	
	private JsonResult deserilizeJsonResult(ClientResponse<String> response)
			throws IOException, JsonParseException, JsonMappingException {
		JsonResult result = mapper.readValue(response.getEntity(),
				JsonResult.class);
		return result;
	}

	private ClientRequest buildUrlEnterRequest(String url, String contentType,
			String filePath) throws FileNotFoundException {
		ClientRequest request = buildJsonRequest(url, contentType);
		String input = readRequestJsonBody(filePath);
		request.body(contentType, input);
		return request;
	}

	private String readRequestJsonBody(String filePath)
			throws FileNotFoundException {
		String input = "";
		Scanner reader = new Scanner(new File(filePath));
		while (reader.hasNext()) {
			input += reader.nextLine();
		}
		reader.close();
		return input;
	}

	private ClientRequest buildJsonRequest(String url, String contentType) {
		ClientRequest request = new ClientRequest(url);
		request.accept(contentType);
		return request;
	}
}
