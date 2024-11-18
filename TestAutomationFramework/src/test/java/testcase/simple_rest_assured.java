package testcase;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class simple_rest_assured {

	
	public static void get_user() {
		given()
			.contentType("application/json")
		.when()
			.get("https://api.restful-api.dev/objects")
		.then()
			.statusCode(200)
			.log().all();
	}
	

	public static void main(String[] args) {
		get_user();

	}

}
