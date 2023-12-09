package com.server.rest.control;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import com.server.rest.util.Messages;

public class CarrinhoControl extends GeneralControl {

	private final String ENDPOINT_CONCLUIR_COMPRA = "/concluir-compra";
	private final String ENDPOINT_CANCELAR_COMPRA = "/cancelar-compra";

	private static CarrinhoControl instance;

	private CarrinhoControl(){
		endpoint = "/carrinhos";
	}

	public static CarrinhoControl getInstance() {

		if (instance == null)
			return new CarrinhoControl();
		return instance;
	}

	public void concluirCompra(String token, int httpStatusCode) {
		performCompraOperation(token, ENDPOINT_CONCLUIR_COMPRA, httpStatusCode, Messages.MESSAGE_DELETE_OK);
	}

	public void cancelarCompra(String token, int httpStatusCode) {
		performCompraOperation(token, ENDPOINT_CANCELAR_COMPRA, httpStatusCode, Messages.MESSAGE_CARRINHO_PRODUTO_REABASTECIDO_OK);
	}

	private void performCompraOperation(final String token,
			final String endpoint,
			final int httpStatusCode,
			final String expectedMessage) {
		given()
				.header(HEADER_AUTHORIZATION, token)
			.when()
				.delete(getEndpoint().concat(endpoint))
			.then()
				.statusCode(httpStatusCode)
				.body(BODY_MESSAGE, is(expectedMessage));
	}
//
//
//	public void concluirCompra(String token, int httpStatusCode) {
//		given()
//				.header(HEADER_AUTHORIZATION, token)
//			.when()
//				.delete(getEndpoint().concat(ENDPOINT_CONCLUIR_COMPRA))
//			.then()
//				.statusCode(httpStatusCode)
//				.body(BODY_MESSAGE, is(Messages.MESSAGE_DELETE_OK));
//	}
//
//	public void cancelarCompra(String token, int httpStatusCode) {
//		given()
//			.header(HEADER_AUTHORIZATION, token)
//		.when()
//			.delete(getEndpoint().concat(ENDPOINT_CANCELAR_COMPRA))
//		.then()
//			.statusCode(httpStatusCode)
//			.body(BODY_MESSAGE, is(Messages.MESSAGE_CARRINHO_PRODUTO_REABASTECIDO_OK));
//	}

}
