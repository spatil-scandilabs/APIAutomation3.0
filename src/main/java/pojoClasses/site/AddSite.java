package pojoClasses.site;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class AddSite {
	
	private String name;
	private String siteId;

	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	
}
