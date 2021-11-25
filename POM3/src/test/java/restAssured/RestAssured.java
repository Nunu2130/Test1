package restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification; 
 

public class RestAssured {
	
	
	@Test
	public void GetWeatherDetails()
	{
		//Specify the base URL to the RESTful web service
		io.restassured.RestAssured.baseURI = "http://demoqa.com/utilities/weather/city";
		
		//Get the ReguestSpecification of the request that you want to sent
		//to the server. The server is specified by the Base URL that we have 
		//Specified in the above step 
		
		RequestSpecification httpRequest = io.restassured.RestAssured.given();
		//Make a request to the server by specifying the method Type and the method URL.
		//This will return the Response from the server. Store the response in a variale/ 
		
		Response response = httpRequest.request(Method.GET,"/Hydrebad");
		//Now let us print the body of the message to see what response 
		//we have received from the server.
			 
		String responseBody =response.getBody().asString();
		System.out.println();
		System.out.println("Response Body is => "+responseBody);
		//First get the JsonPath object  instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		
		//Then simply query the JasonPath object to get a String value of the node
		//Specified by JsonPath: City(Note: You Should not put $ in the Java code)
		
		String city = jsonPathEvaluator.get("City");
		
		//Let us print the city variable to see what we got 
		System.out.println();
		System.out.println("City received from Response : " +city);
		System.out.println();
		
		//Validate the Response 
		Assert.assertEquals(city,"Hydrebad","Correct status code returned");
		
		//Get the status code from the Response In case of
		//a successful interaction with the web service, we 
		//should get a status code of 200 
		
		//int statusCode = response.getStatusCode();
		
		//Assert that correct status code is returned 
		//Assert.assertEquals(statusCode/*actual value*/, 200/*expected value*/,"Correct status code returned");

	}

}
