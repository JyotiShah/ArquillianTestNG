package com.company.module.testFramework.componentname.pages.homePage;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.Graphene;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.company.module.testFramework.helper.logger.Log;



@Location(value = "url")
public class LoginPage {

	private Logger log = Log.getLogger(LoginPage.class);
	@Drone
	private WebDriver driver;

	private static String url = "url";

	/**
	 * Elements to handle Login
	 */
	@FindBy(css = "input[title='userName']")
	WebElement username;

	@FindBy(css = "input[title='password']")
	WebElement password;

	@FindBy(css = "button[title='submit']")
	WebElement submitLogin;

	public void getApplicationUrl() {
		this.driver.get(url);
		log.info("Browser Launched and Logged in to Application URL - " + url);
	}

	
	/**
	 * Method to enter username
	 * 
	 * @param username
	 */
	public void enterUserName(String username) {
		log.info("entering username...." + username);
		Graphene.guardNoRequest(username);
		this.username.clear();
		this.username.sendKeys(username);

	}

	/**
	 * Method to enter password
	 * 
	 * @param password
	 */
	public void enterPassword(String password) {
		log.info("entering password...." + password);
		Graphene.waitGui().withTimeout(2, TimeUnit.SECONDS);
		Graphene.guardNoRequest(password);
		this.password.clear();
		this.password.sendKeys(password);
		;
	}

	/**
	 * Click on submit button
	 * 
	 * @return HomePage
	 */
	public HomePage clickOnSubmitButton() {
		log.info("clicking on submit button...");
		this.submitLogin.click();
		return new HomePage();
	}

	/**
	 * Login to application
	 * 
	 * @param Username
	 * @param Password
	 */
	public void loginToApplication(String Username, String Password) {
		getApplicationUrl();
		enterUserName(Username);
		enterPassword(Password);
		clickOnSubmitButton();
	}

}
