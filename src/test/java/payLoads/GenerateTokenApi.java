package payLoads;

import pojoClasses.generateToken.ApiKeys;

public class GenerateTokenApi {
	
	public ApiKeys addFormParams() {
		
		ApiKeys formParam = new ApiKeys();
		formParam.setApikey("abilitykey1");
		formParam.setApisecret("abilitykey2");
		return formParam;
	}

}
