package testcase;

import java.util.Base64;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;




public class get_user_profile {

public static String getSpotifyToken() {
        
        String clientId = "b0be9b6d28044908b21c9e7e6c5e5c85";
        String clientSecret = "6cfe6965f50f4210895b0cb463d3991c";

       
        String authString = clientId + ":" + clientSecret;
        String authBase64 = Base64.getEncoder().encodeToString(authString.getBytes());

        
        String tokenUrl = "https://accounts.spotify.com/api/token";

      
        Response response = RestAssured.given().header("Authorization", "Basic " + authBase64)
        		.contentType("application/x-www-form-urlencoded").formParam("grant_type", "client_credentials")
                .post(tokenUrl);

        
        String accessToken = response.jsonPath().getString("access_token");
        return accessToken;
    }
	

	public static void get_user_profile(String token, String id){
		String url = "https://api.spotify.com/v1/users/"+id;
		Response response = RestAssured.given().header("Authorization", "Bearer " + token).get(url);
        response.then().statusCode(200);
        System.out.println("User Profile Details: " + response.prettyPrint());
	}
	
	

	public static void main(String[] args) {
		
		String token = getSpotifyToken();
        get_user_profile(token, "31mlbxzeo7s2lqyobqvgucwwj6qe");
	}

}
