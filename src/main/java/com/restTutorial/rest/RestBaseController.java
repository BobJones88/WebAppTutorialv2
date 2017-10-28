package com.restTutorial.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class RestBaseController {
	public static Response addCorsHeaders(ResponseBuilder response) {
		return response.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
		.allow("OPTIONS").build();
	}
}
