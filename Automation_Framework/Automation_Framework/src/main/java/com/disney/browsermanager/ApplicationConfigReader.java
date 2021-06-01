
package com.disney.browsermanager;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfigReader {

	public ApplicationConfigReader() {
		PropertyLoader.newInstance().populate(this);
	}

	@Property(value = "Browser")
	private String Browser;

	@Property(value = "Url")
	private String WebsiteUrl;

	@Property(value = "MaxPageLoadTime")
	private int MaxPageLoadTime;

	@Property(value = "ImplicitlyWaitTime")
	private int implicitWaitTime;

	@Property(value = "ExplicitWaitTime")
	private int explicitWaitTime;
	
	@Property(value = "UserName")
	private String UserName;
	
	@Property(value = "Password")
	private String Password;

	public String getBrowser() {
		return Browser;
	}

	public String getWebsiteUrl() {
		return WebsiteUrl;
	}

	public int getMaxPageLoadTime() {
		return MaxPageLoadTime;
	}

	public int getImplicitlyWait() {
		return implicitWaitTime;
	}

	public int getExplicitWait() {
		return explicitWaitTime;
	}
	
	public String getUserName() {
		return UserName;
	}
	
	public String getPassword() {
		return Password;
	}

}
