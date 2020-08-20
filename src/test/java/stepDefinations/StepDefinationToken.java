package stepDefinations;

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

public class StepDefinationToken extends BaseUriParameters {
	
	//ResponseSpecification validatStatusCode;
	RequestSpecification requestToken;
	Response generateToken;
	String authTokenString;
	String authTokenValue;

	

	@Given("Generate token Paylod")
	public void generate_token_paylod() throws IOException {
		// Write code here that turns the phrase above into concrete actions

		

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//validatStatusCode = new ResponseSpecBuilder().expectStatusCode(200).expectHeader("Server", "nginx/1.16.1")
		//		.build();

		//requestToken = given().spec(requestSpecification());

	}

	@When("user calls Generate Token API with POST https request")
	public void user_calls_generate_token_api_with_post_https_request() {
		// Write code here that turns the phrase above into concrete actions

		/*generateToken = requestToken.when().post("/api/authtoken").then().spec(responseSpecification())
				.extract().response();
		
		authTokenString = generateToken.asString();

		System.out.println(authTokenString);
*/
	}

	@Then("the API call should be sucessfull with status code {int}")
	public void the_api_call_should_be_sucessfull_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		
		//assertEquals(generateToken.getStatusCode(), 200);
		
	}

	@Then("response body should have apitoken")
	public void response_body_should_have_apitoken() {
		// Write code here that turns the phrase above into concrete actions
		
		//String string = authTokenValue.asString();
		/*JsonPath js = new JsonPath(authTokenString);
		authTokenValue= js.get("apitoken");
		System.out.println(authTokenValue);
		*/
		
	}

}
