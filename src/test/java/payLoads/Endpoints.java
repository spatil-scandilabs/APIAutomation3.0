package payLoads;
// Enum is a special class in java which has collection of constants or methods

public enum Endpoints {
	
	//All Sites related api enums
	AddSite("api/v3.0/partners/ABILITY/sites"),
	AddSiteInvalidPartner("api/v3.0/partners/TRIZETTO/sites"),
	UpdateSite(""),
	GetSite("");

	
	private String apiUrl;
	
	Endpoints(String apiUrl){
		
		this.apiUrl= apiUrl;
		
	}
	
	public String getApiUrl() {
		return apiUrl;
		
		
	}
}
