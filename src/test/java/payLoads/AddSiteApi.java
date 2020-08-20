package payLoads;

import org.apache.commons.lang3.RandomStringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pojoClasses.site.AddSite;;
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddSiteApi {

	String randomSiteId;

	public AddSite addSite() {

		// Generate random site id of 6 characters
		randomSiteId = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
		System.out.println(randomSiteId);

		// Add Site payload
		AddSite siteInfo = new AddSite();
		siteInfo.setName("000 Test Site Name");
		siteInfo.setSiteId(randomSiteId);
		return siteInfo;

	}
	
	public AddSite invalidJsonSiteId() {

		// Add Site payload
		AddSite siteIdMissing = new AddSite();
		siteIdMissing.setName("000 Test Site Name");
		return siteIdMissing;

	}
	

	public AddSite invalidJsonSiteName() {
		
		randomSiteId = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
		System.out.println(randomSiteId);

		// Add Site payload
		AddSite siteNameMissing = new AddSite();
		siteNameMissing.setSiteId(randomSiteId);
		return siteNameMissing;

	}
	
	
}
