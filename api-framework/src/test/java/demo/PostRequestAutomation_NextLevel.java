package demo;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PostRequestAutomation_NextLevel {
	
	
	@Test
	public void postCallAutomation() {
		baseURI = "http://localhost:3000";
		String payload = "{\r\n"
				+ "\"name\": \"Loretta Laney\",\r\n"
				+ "\"location\": \"New York\",\r\n"
				+ "\"phone\": \"313-456-7890\",\r\n"
				+ "\"courses\": [\r\n"
				+ "\"Science\",\r\n"
				+ "\"History\",\r\n"
				+ "\"Accounts\"\r\n"
				+ "]\r\n"
				+ "}";
		Response response = given().header("Content-Type", "application/json").body(payload).post("/students");
		System.out.println(response.asPrettyString());
	}

}
