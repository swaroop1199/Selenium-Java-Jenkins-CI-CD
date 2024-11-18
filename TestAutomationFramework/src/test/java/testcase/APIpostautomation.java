package testcase;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIpostautomation {

	public static void main(String[] args) {
		
		RestAssured.baseURI="http://localhost:8090";
		RequestSpecification Rsp = RestAssured.given().log().all();
		Response res = Rsp.request(Method.POST,"/addition?c=25");
		String resbody=res.getBody().asString();
		int statuscode = res.statusCode();
		Assert.assertEquals(statuscode, 200);
		System.out.println(resbody);
		System.out.println("success: "+statuscode);	

	}

}
