package payLoads;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.junit.Test;

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

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseUriParameters {

	public static String authToken;
	public static RequestSpecification url;
	ResponseSpecification statusCode;
	String authTokenValue;
	PrintStream logs;
	

	public RequestSpecification requestSpecification() throws IOException {

		if (url == null) {
			logs = new PrintStream(new FileOutputStream("logging.txt"));

			System.out.println(environmentVariables("baseUrl"));

//			authToken = given().baseUri(environmentVariables("baseUrl")).formParam("apikey", "abilitykey1")
//					.formParam("apisecret", "abilitykey2").filter(RequestLoggingFilter.logRequestTo(logs))
//					.filter(ResponseLoggingFilter.logResponseTo(logs)).when().post("/api/authtoken").then().log().all()
//					.extract().response().asString();

			
			authToken = given().baseUri(environmentVariables("baseUrl"))
					.formParam("apikey", environmentVariables("apikey"))
					.formParam("apisecret", environmentVariables("apisecret"))
					.filter(RequestLoggingFilter.logRequestTo(logs))
					.filter(ResponseLoggingFilter.logResponseTo(logs)).when().post("/api/authtoken").then().log().all()
					.extract().response().asString();
			
			
			JsonPath js = new JsonPath(authToken);
			authTokenValue = js.get("apitoken");
			System.out.println(authTokenValue);

			url = new RequestSpecBuilder().setBaseUri(environmentVariables("baseUrl"))
					.addHeader("Content-Type", "application/json").addHeader("auth_id", "abilitykey1")
					.addHeader("auth_token", authTokenValue).addFilter(RequestLoggingFilter.logRequestTo(logs))
					.addFilter(ResponseLoggingFilter.logResponseTo(logs)).setContentType(ContentType.JSON).build();

			return url;
		}
		return url;
	}

	public static String environmentVariables(String url) throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/shirishpatil/madaket/eclipse/Api3.0AutomationFramework/src/test/java/payLoads/global.properties");
		prop.load(fis);

		return prop.getProperty(url);

	}

	public ResponseSpecification responseSpecification() {

		return statusCode = new ResponseSpecBuilder().expectStatusCode(200).expectHeader("Server", "nginx/1.16.1")
				.build();
	}
}





//private static Logger logger = Logger.getLogger(BaseUriParameters.class.getName());
//FileHandler fh;   
//-----------------------------------------------------------------------------------------------------	
//public RequestSpecification requestSpecification() throws IOException {
//	
////	if(fh==null) {
////	fh = new FileHandler("logging_new.txt");   
////	logger.addHandler(fh); 
////	}
//	
//		if (logs==null) {
//			
//		logs= new PrintStream(new FileOutputStream("logging.txt"));
//		
//		}
//		
//		System.out.println(environmentVariables("baseUrl"));
//		
//		
//			System.out.println("==========IF STATEMENT============");
//			System.out.println("--------111111");
//			//logger.info("+++++++New Log File test++++++++");
//			
//			if(authTokenValue==null) {
//		authToken= given().baseUri(environmentVariables("baseUrl"))
//				.formParam("apikey", "abilitykey1").formParam("apisecret", "abilitykey2")
//				.when().post("/api/authtoken")
//				.then().log().all().extract().response().asString();
//				
//			
//		JsonPath js = new JsonPath(authToken);
//		authTokenValue= js.get("apitoken");
//		System.out.println(authTokenValue);
//			}
//			
//		System.out.println(authTokenValue);
//			
//				
//		System.out.println("-------22222222-------");
//		
//		System.out.println("-------33333333-------");
//		
//		
//		if(url==null) {
//		 url = new RequestSpecBuilder().setBaseUri(environmentVariables("baseUrl"))
//				.addHeader("Content-Type", "application/json").addHeader("auth_id", "abilitykey1")
//				.addHeader("auth_token", authTokenValue)
//				.addFilter(RequestLoggingFilter.logRequestTo(logs))
//				.addFilter(ResponseLoggingFilter.logResponseTo(logs))
//				.build();

//url = new RequestSpecBuilder().setBaseUri(environmentVariables("baseUrl"))
//.addHeader("Content-Type", "application/json").addHeader("auth_id", "abilitykey1")
//.addHeader("auth_token", authTokenValue)
//.addFilter(RequestLoggingFilter.logRequestTo(logs))
//.addFilter(ResponseLoggingFilter.logResponseTo(logs))
//.build();

//		
//		System.out.println("-------4444444-------");
//		//System.out.println(url);
//		return url;
//		
//		}
//		return url;
//}
//		
//-----------------------------------------------------------------------------------------------------	

/*
 * System.out.println("--------111111");
 * 
 * if (logs==null) { logs= new PrintStream(new FileOutputStream("logging.txt"));
 * } //PrintStream logs= new PrintStream(new FileOutputStream("logging.txt"));
 * System.out.println(environmentVariables("baseUrl"));
 * 
 * authToken= given().baseUri(environmentVariables("baseUrl"))
 * .formParam("apikey", "abilitykey1").formParam("apisecret", "abilitykey2")
 * .when().post("/api/authtoken")
 * .then().log().all().extract().response().asString();
 * 
 * JsonPath js = new JsonPath(authToken); authTokenValue= js.get("apitoken");
 * System.out.println(authTokenValue);
 * 
 * System.out.println("-------22222222-------");
 * 
 * System.out.println("-------33333333-------");
 * 
 * if(url==null) { return url = new
 * RequestSpecBuilder().setBaseUri(environmentVariables("baseUrl"))
 * .addHeader("Content-Type", "application/json").addHeader("auth_id",
 * "abilitykey1") .addHeader("auth_token", authTokenValue)
 * .addFilter(RequestLoggingFilter.logRequestTo(logs))
 * .addFilter(ResponseLoggingFilter.logResponseTo(logs)) .build();
 * 
 * }
 * 
 * System.out.println("-------4444444-------"); System.out.println(url); return
 * url;
 * 
 * /*
 * 
 * /*authToken= given().baseUri(environmentVariables("baseUrl"))
 * .formParam("apikey", "abilitykey1").formParam("apisecret", "abilitykey2")
 * .filter(RequestLoggingFilter.logRequestTo(logs))
 * .filter(ResponseLoggingFilter.logResponseTo(logs))
 * .when().post("/api/authtoken") .then().extract().response().asString();
 * 
 * JsonPath js = new JsonPath(authToken); authTokenValue= js.get("apitoken");
 * System.out.println(authTokenValue);
 * 
 * System.out.println("-------22222222-------");
 * 
 * System.out.println("-------33333333-------");
 * 
 * if(url==null) {
 * 
 * url = new RequestSpecBuilder().setBaseUri(environmentVariables("baseUrl"))
 * .addHeader("Content-Type", "application/json").addHeader("auth_id",
 * "abilitykey1") .addHeader("auth_token", authTokenValue) .build();
 * 
 * System.out.println("-------4444444-------");
 * 
 * return url; } return url;
 * 
 * 
 * 
 * 
 * 
 * }
 */

/*
 * public RequestSpecification requestSpecification() throws IOException {
 * 
 * 
 * //System.out.println("-------33333333-------");
 * 
 * if(url==null) {
 * 
 * url = new RequestSpecBuilder().setBaseUri(environmentVariables("baseUrl"))
 * .addHeader("Content-Type", "application/json").addHeader("auth_id",
 * "abilitykey1") .addHeader("auth_token", authTokenValue) .build();
 * 
 * System.out.println("-------4444444-------");
 * 
 * return url; } return url; }
 */
