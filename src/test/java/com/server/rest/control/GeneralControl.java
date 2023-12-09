package com.server.rest.control;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

import org.apache.http.HttpStatus;

import com.server.rest.dto.GeneralDTO;
import com.server.rest.util.Environment;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

public abstract class GeneralControl {

	private static final String PARAMETER_ID = "_id";
	protected static final String HEADER_AUTHORIZATION = "Authorization";
	protected static final String BODY_MESSAGE = "message";

	protected static String endpoint;

	public void list(){
		when()
				.get(getEndpoint())
			.then()
				.statusCode(HttpStatus.SC_OK);
	}

	protected ResponseBodyExtractionOptions get(String id, int statusCode){
		return given()
						.pathParam(PARAMETER_ID, id)
					.when()
						.get(getEndpointWithId())
					.then()
						.statusCode(statusCode)
						.extract().body();
	}

	protected ResponseBodyExtractionOptions getValidParameter(String id,
			int statusCode,
			String parameter,
			Object expected){
		return
				given()
						.pathParam(PARAMETER_ID, id)
					.when()
						.get(getEndpointWithId())
					.then()
						.statusCode(statusCode)
						.body(parameter, is(expected))
						.extract().body();
	}

	public String post(GeneralDTO dto, int statusCode, String message){
		return postDefault(dto, statusCode, message, null, PARAMETER_ID);
	}

	public String postWithToken(GeneralDTO dto, String token, int statusCode, String message){
		return postDefault(dto, statusCode, message, token, PARAMETER_ID);
	}

	protected String postDefault(
			final GeneralDTO dto,
			final int statusCode,
			final String message,
			final String token,
			final String parameter){

		RequestSpecification given = given();

		if(token != null)
			given.header(HEADER_AUTHORIZATION, token);

		return given
					.body(dto.toJson())
					.contentType(ContentType.JSON)
				.when()
					.post(getEndpoint())
				.then()
					.statusCode(statusCode)
					.body(BODY_MESSAGE, is(message))
					.extract().path(parameter);
	}

	public void delete(String id, int httpStatusCode, String message){
		deleteDefault(id, httpStatusCode, message, null);
	}

	public void deleteWithToken(String id, String token, int httpStatusCode, String message){
		deleteDefault(id, httpStatusCode, message, token);
	}

	private void deleteDefault(String id,
			int httpStatusCode,
			String message,
			String token){

		RequestSpecification given = given();

		if(token != null)
			given.header(HEADER_AUTHORIZATION, token);

		given
				.pathParam(PARAMETER_ID, id)
			.when()
				.delete(getEndpointWithId())
			.then()
				.statusCode(httpStatusCode)
				.body(BODY_MESSAGE, is(message))
				.extract().path(PARAMETER_ID);
	}

	protected String getEndpoint(){
		return Environment.server.concat(endpoint);
	}

	protected String getEndpointWithId(){
		return getEndpoint().concat("/{_id}");
	}

}
