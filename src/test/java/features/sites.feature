Feature: Create new Site and releted testcases

Scenario: Verify correct Site is being created
	Given "Add Site" Paylod
	When user calls "AddSite" API with "POST" https request
	Then the API call should return response with status code 201
	And "success" in response body is "true"
	And response body should have created "siteId"
	

Scenario: Verify create Site API with invalid JSON element Site Id
	Given "Add Site" Paylod with invalid Json element Site Id
	When user calls "AddSite" API with "POST" https request
	Then the API call should return response with status code 412
	And API request should be unsuccessful with "success" in response body "false"
	And response body should have "businessErrorKey"
	And businessErrorKey in error response is "JSON_ELEMENT_MISSING"
	And message in error response is "JSON element missing 'Required field 'siteId' is missing'"
	
	
Scenario: Verify create Site API with invalid JSON element Site Name
	Given "Add Site" Paylod with invalid Json element Site Name
	When user calls "AddSite" API with "POST" https request
	Then the API call should return response with status code 412
	And API request should be unsuccessful with "success" in response body "false"
	And response body should have "businessErrorKey"
	And businessErrorKey in error response is "JSON_ELEMENT_MISSING"
	And message in error response is "JSON element missing 'Required field 'name' is missing'"
	
	
Scenario: Verify create Site API with different Partner 
	Given "Add Site" Paylod with different Partner information
	When user calls "AddSiteInvalidPartner" API with "POST" https request
	Then the API call should return response with status code 404
	And API request should be unsuccessful with "success" in response body "false"
	And response body should have "businessErrorKey"
	And businessErrorKey in error response is "PARTNER_MISSING"
	And message in error response is "JSON element missing 'Required field 'name' is missing'"	
	
	
	