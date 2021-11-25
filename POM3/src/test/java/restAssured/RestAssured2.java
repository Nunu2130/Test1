package restAssured;


import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;


public class RestAssured2 {
	
	
	@BeforeClass
	public void setup()
	{
		//Specify the base URL to the RESTful web service
	
		
	}
	
	@Test	
	public void getRequest()
	
	{
		RestAssured.baseURI = "https://bookstore.toolsqa.com/BookStore/v1/Books";
		
		//The HTTP GET request is used to fetch a resource from a server 
		
			Response response = given()
				.contentType(ContentType.JSON)
				.when()
				.get("/posts")
				.then()
				.extract().response();
		
		Assert.assertEquals(response.statusCode(), 200);
		
	
		//Assert.assertEquals(response.jsonPath().getString("title[1]"),"qui est esse");

		
		

	
		
	}

}
