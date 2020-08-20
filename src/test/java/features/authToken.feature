Feature: Generate and validate Authentication Token

Scenario: Verify correct auth token is being created
	Given Generate token Paylod
	When user calls Generate Token API with POST https request
	Then the API call should be sucessfull with status code 200
	And response body should have apitoken
