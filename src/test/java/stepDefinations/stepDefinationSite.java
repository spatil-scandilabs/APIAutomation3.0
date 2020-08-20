package stepDefinations;

import io.cucumber.java.en.Given;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payLoads.BaseUriParameters;
import payLoads.Endpoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import payLoads.AddSiteApi;
import payLoads.BaseUriParameters;
import payLoads.GenerateTokenApi;
import pojoClasses.site.AddSite;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payLoads.BaseUriParameters;

public class stepDefinationSite extends BaseUriParameters {

	RequestSpecification addSite;
	Response addSiteRequest;
	static String siteIdValue;

	AddSiteApi addSiteData = new AddSiteApi();

	@Given("{string} Paylod")
	public void paylod(String siteIdPayload) throws IOException {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("Start API request with GIVEN");
		addSite = given().spec(requestSpecification()).body(addSiteData.addSite());

		System.out.println("------55555555------");

	}

	@When("user calls {string} API with {string} https request")
	public void user_calls_api_with_https_request(String apiRequest, String httpMethod) {
		
		Endpoints endpointRequest= Endpoints.valueOf(apiRequest);
		endpointRequest.getApiUrl();
		System.out.println(endpointRequest.getApiUrl());
		
		System.out.println("API request with WHEN");
		
		if (httpMethod.equalsIgnoreCase("POST")) {
			addSiteRequest = addSite.when().post(endpointRequest.getApiUrl());
		}
		else if (httpMethod.equalsIgnoreCase("PUT")) {
			addSiteRequest = addSite.when().put(endpointRequest.getApiUrl());
		}
		else {
			addSiteRequest = addSite.when().get(endpointRequest.getApiUrl());
		}

		

		System.out.println("------666666------");

	}

	@Then("the API call should return response with status code {int}")
	public void the_api_call_should_return_response_with_status_code(Integer statusCode) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("API request with THEN");
		
		assertEquals((Object)addSiteRequest.getStatusCode(), (Object)statusCode);
		
	
		System.out.println("-----77777-----");
	}
	
	/*@Then("the API call should return response with status code {string}")
	public void the_api_call_should_return_response_with_status_code(int statusCode) {
	    // Write code here that turns the phrase above into concrete actions
		statusCode= addSiteRequest.getStatusCode();
		assertEquals(addSiteRequest.getStatusCode(), statusCode);

		System.out.println("-----77777-----");
	}*/
	
	@Then("response body should have created {string}")
	public void response_body_should_have_created(String siteIdValue) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("API request with THEN");
		
		String testResult1 = addSiteRequest.asString();
		
		JsonPath responseData1 = new JsonPath(testResult1);
		siteIdValue= responseData1.getString("siteId");
		
		assertEquals(responseData1.getString("siteId").toString(), siteIdValue);
		
		System.out.println(siteIdValue);

	

	}
		
	@Then("response body should have {string}")
	public void response_body_should_have(String errorKey) {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("API request with THEN");
		
		String testResult2 = addSiteRequest.asString();
		JsonPath responseData2 = new JsonPath(testResult2);
		
		errorKey= responseData2.getString("error.businessErrors.businessErrorKey");
		
		System.out.println("--++++++++++++++=================");
		System.out.println(responseData2.getString("error.businessErrors.businessErrorKey"));
		
		assertEquals(responseData2.getString("error.businessErrors.businessErrorKey").toString(), errorKey);
		
		System.out.println(errorKey);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String responseKey, String responseKeyValue) {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("API request with THEN");
		
		String testResult2 = addSiteRequest.asString();

		JsonPath responseData2 = new JsonPath(testResult2);

		assertEquals(responseData2.getString(responseKey).toString(), responseKeyValue);
		System.out.println(responseKeyValue);
	}

	@Given("{string} Paylod with invalid Json element Site Id")
	public void paylod_with_invalid_json_element_site_id(String invalidJsonSiteId) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Start API request with GIVEN");
		
		addSite = given().spec(requestSpecification()).body(addSiteData.invalidJsonSiteId());

		System.out.println("------778678686------");
		
	}

	@Then("API request should be unsuccessful with {string} in response body {string}")
	public void api_request_should_be_unsuccessful_with_in_response_body(String errorResponseKey, String errorResponseValue) {
	    // Write code here that turns the phrase above into concrete actions
        
		System.out.println("API request with THEN");
		
		String testResult3 = addSiteRequest.asString();

		JsonPath responseData3 = new JsonPath(testResult3);

		assertEquals(responseData3.getString(errorResponseKey).toString(), errorResponseValue);
		System.out.println(errorResponseValue);
	}
	
//	@Then("{string} in error response is {string}")
//	public void in_error_response_is(String businessErrorKey, String businessErrorValue) {
//	    // Write code here that turns the phrase above into concrete actions
//	    
//        System.out.println("API request with THEN");
//		
//		String testResult4 = addSiteRequest.asString();
//		JsonPath responseData4 = new JsonPath(testResult4);
//		
//		String businessErrorKey1= responseData4.getString("error.businessErrors.businessErrorKey");
//
//		
//		assertEquals(businessErrorKey1.toString(), businessErrorKey);
//		
//		System.out.println(businessErrorKey);
//		
//		String businessErrorValu1= responseData4.getString("error.businessErrors.message");
//		
//		assertEquals(businessErrorValu1.toString(), businessErrorValue);
//		System.out.println(businessErrorValue);
//	}
	
	@Then("businessErrorKey in error response is {string}")
	public void business_error_key_in_error_response_is(String businessErrorValue) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("API request with THEN");
		
		String testResult4 = addSiteRequest.asString();
		JsonPath responseData4 = new JsonPath(testResult4);
		
		String businessErrorValue1= responseData4.getString("error.businessErrors.businessErrorKey"); 
		System.out.println("????????????????????");
		System.out.println(businessErrorValue1);
		
		System.out.println("<><><><><><><><><><><<><>");
		System.out.println(businessErrorValue);
		
		assertEquals(businessErrorValue1.toString(), businessErrorValue);
		//assertEquals(businessErrorValue1.toString(), businessErrorValue);
		
	}
	
	@Then("message in error response is {string}")
	public void message_in_error_response_is(String messageValue) {
	    // Write code here that turns the phrase above into concrete actions
System.out.println("API request with THEN");
		
		String testResult5 = addSiteRequest.asString();
		JsonPath responseData5 = new JsonPath(testResult5);
		
		String messageValue1= responseData5.getString("error.businessErrors.message"); 
		
		assertEquals(messageValue1.toString(), messageValue);
		
	}
	
	
	@Given("{string} Paylod with invalid Json element Site Name")
	public void paylod_with_invalid_json_element_site_name(String string) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Start API request with GIVEN");
		
		addSite = given().spec(requestSpecification()).body(addSiteData.invalidJsonSiteName());

		System.out.println("------!!!!!!!!!!------");
		
	}

	
	@Given("{string} Paylod with different Partner information")
	public void paylod_with_different_partner_information(String string) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
System.out.println("Start API request with GIVEN");
		
		addSite = given().spec(requestSpecification()).body(addSiteData.addSite());

		System.out.println("------!!!!!!!!!!------");
	}

	
	
}
