package testcase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class APIautomation {

	public static void main(String[] args) {
		
		RestAssured.baseURI="https://api.restful-api.dev";
		RequestSpecification Rsp = RestAssured.given().log().all();
		Response res = Rsp.request(Method.GET,"/objects?id=3");
		String resbody=res.getBody().asString();
		int statuscode = res.statusCode();
		Assert.assertEquals(statuscode, 200);
		System.out.println(resbody);
		System.out.println("success: "+statuscode);	
	}
}

