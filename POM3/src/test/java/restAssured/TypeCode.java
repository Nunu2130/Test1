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

@Test
public class TypeCode {
	
 
	
	public void statusCode()
	
	{
		
		given().
		when().
			get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200);
			
	}
	
	@Test
	public void pathtest()
	{
	
			
			given().
			when().
				get("https://reqres.in/api/users?page=2").
			then().
				assertThat().
				body("page",equalTo(2));
				
	}

		
	@Test
	public void testDataIDofData0()
	{
	
			
			given().
			when().
				get("https://reqres.in/api/users?page=2").
			then().
				assertThat().
				body("page",equalTo(2),
				"data[0].id",equalTo(7));
		
				
	}
	
	@Test
	public void testBooks()
	{
		given().
			when().
				get("https://bookstore.toolsqa.com/BookStore/v1/Books").
			then().
				assertThat().
				body("books[0].title",equalTo("Git Pocket Guide"));
				
	}
	
	@Test
	public void howManyDataElements()
	{
		given().when().get("https://bookstore.toolsqa.com/BookStore/v1/Books")
				.then()
				.assertThat()
				.statusCode(200)
				.body("size()",equalTo(6));
				
	}
	
	@Test
	public void size()
	{
		given().when().get("https://pokeapi.co/api/v2/pokemon?limit=100&offset=200")
				.then()
				.assertThat()
				.statusCode(200)
				.body("size()",equalTo(4));
				
	}
	
	
	@Test
	public void queryparma()
	{
		given().queryParam("limit","100")
		.queryParam("offset","200")
		.when().get("https://pokeapi.co/api/v2/pokemon").then().log()
		.body();
	}
	
	
	@Test
	public void givenExample()
	{
		given().queryParam("CUSTOMER_ID","68195")
		.queryParam("PASSWORD","1234!")
		.queryParam("Account_No","1")
		.when().get("https://demo.guru99.com/V4/sinkministatement.php").then().log()
		.body();
	}
	

	private static String requestBody = "{\n" +
	        "  \"title\": \"foo\",\n" +
	        "  \"body\": \"bar\",\n" +
	        "  \"userId\": \"2\" \n}";

	@Test
	public void postRequest()
	
	{
	
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	   //HTTP POST request is used to post data or create a resource on a server.
	Response response = 
	      given()
	               .header("Content-type", "application/json")
	               .and().body(requestBody)
	              .when()
	               .post("/posts/")
	              .then().
	               //.extract().response();
	         log().
	         all().
	         extract().
	         response();
	Assert.assertEquals(response.statusCode(),201);
	Assert.assertEquals(response.jsonPath().getString("title"),"foo");
	Assert.assertEquals( response.jsonPath().getString("body"),"bar");
	Assert.assertEquals(response.jsonPath().getString("userId"),"2");
	Assert.assertEquals(response.jsonPath().getString("id"),"101");
	
	}

	
	@Test
	public void putRequest()
	
	{
	
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	   //HTTP POST request is used to post data or create a resource on a server.
	Response response = 
	      given()
	               .header("Content-type", "application/json")
	               .and().body(requestBody)
	              .when()
	               .put("/posts/7")
	              .then().
	               //.extract().response();
	         log().
	         all().
	         extract().
	         response();
	Assert.assertEquals(response.statusCode(),200);
	Assert.assertEquals(response.jsonPath().getString("title"),"foo");
	Assert.assertEquals( response.jsonPath().getString("body"),"bar");
	Assert.assertEquals(response.jsonPath().getString("userId"),"2");
	Assert.assertEquals(response.jsonPath().getString("id"),"7");
	
	}
	
	@BeforeClass
	public static void setup() 
	{ RestAssured.baseURI = "https://jsonplaceholder.typicode.com";}
	
	
	@Test
	public void patchRequest()
	
	{
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	 
	Response response = 
	      given()
	               .header("Content-type", "application/json")
	               .and().body(requestBody)
	              .when()
	               .delete("/posts/1")
	              .then().
	               extract().response();
	
	Assert.assertEquals(response.statusCode(),200);
	     
	}
	
	

	
}
