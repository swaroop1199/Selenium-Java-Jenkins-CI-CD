package testcase;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Base64;


import org.testng.Assert;


public class get_playlist_automation {
	
	public static String getToken() {
        
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

    
    public static void getPlaylist(String token, String playlistId) {
        
        String playlistUrl = "https://api.spotify.com/v1/playlists/" + playlistId;
        Response response = RestAssured.given().header("Authorization", "Bearer " + token).get(playlistUrl);
        response.then().statusCode(200);
        
        response.then()
        .body("name", equalTo("This is Playlist Created by API call"))
        .body("owner.display_name", equalTo("swaroop_hire"));
        
        
        //System.out.println("ACCESS TOKEN: " + token);
        System.out.println("PLAYLIST DETAILS: " + response.prettyPrint());
    }
	
	public static void main(String[] args) {
		String token = getToken();
        getPlaylist(token, "16m7vcSp3Pe6KNvhDFeOpr");
	}

}
