package com.company.module.testFramework.componentname.pages.homePage;

import org.apache.log4j.Logger;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.company.module.testFramework.helper.logger.Log;

public class HomePage {
	private Logger log = Log.getLogger(HomePage.class);
	@Drone
	private WebDriver driver;
	@ArquillianResource
	JavascriptExecutor js;
	/**
	 * Element Locators for user name and logout 
	 */
		
	@FindBy(css="[title='logout']")
	public WebElement Logout;
	
	@FindBy(css="[title='login']")
	public WebElement Login;
	
	public void logOutApplication()  {
		Graphene.waitGui().until().element(Logout).is().clickable();
		this.Logout.click();
		// js.executeScript("arguments[0].click();", logout);
		String currentURL = driver.getCurrentUrl();
		log.info("User Logged out sucessfully from Application - "+currentURL);
		
	}

	public boolean loggedInUserVerification(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getLogoutText() {
		// TODO Auto-generated method stub
		return null;
	}
}
