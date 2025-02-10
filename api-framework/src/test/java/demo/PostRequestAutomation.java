package demo;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestAutomation {
	
	
	@Test
	public void postCallAutomation() {
		RestAssured.baseURI = "http://localhost:3000";
		String payload = "{\r\n"
				+ "\"name\": \"Erica John\",\r\n"
				+ "\"location\": \"New Jersey\",\r\n"
				+ "\"phone\": \"313-456-7890\",\r\n"
				+ "\"courses\": [\r\n"
				+ "\"Arts\",\r\n"
				+ "\"History\",\r\n"
				+ "\"Accounts\"\r\n"
				+ "]\r\n"
				+ "}";
		RequestSpecification a = RestAssured.given();
		RequestSpecification b = a.header("Content-Type", "application/json");
		RequestSpecification c = b.body(payload);
		Response response = c.post("/students");
		System.out.println(response.asPrettyString());
	}

}
