package br.ce.wcaquino.rest;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.http.ContentType;

public class integracaoAPI {
	
	@Test
	
	public void LogandoAPIpegandoToken() {
		Map<String, String> login = new HashMap<String, String>();
		login.put("usuario", "100000");
		login.put("senha", "123456");		
		
		given()
			.log().all()
			.body(login)
			.contentType(ContentType.JSON)
		.when()
			.post("http://servicosflex.rpinfo.com.br:9000/v1.1/auth")
		.then()
			.log().all()
			.statusCode(200)
						
	;	
                                                                                                   		
	}
	
	@Test
	public void ConsumindoProdutos() {
		
		given()
			.log().all()
		.when()
		    .header("token","COLAR TOKEN AQUI")
			.get("http://servicosflex.rpinfo.com.br:9000/v2.0/produtounidade/listaprodutos/0/unidade/83402711000110") 
		.then()
		 
			.log().all()
			.statusCode(200)
		
			;
	}


}
