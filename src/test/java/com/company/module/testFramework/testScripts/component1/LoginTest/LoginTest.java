package com.company.module.testFramework.testScripts.component1.LoginTest;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Page;
import org.jboss.arquillian.testng.Arquillian;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.company.module.testFramework.componentname.pages.homePage.HomePage;
import com.company.module.testFramework.componentname.pages.homePage.LoginPage;
import com.company.module.testFramework.helper.logger.Log;


@RunAsClient
public class LoginTest extends Arquillian {
	
	private Logger log = Log.getLogger(LoginTest.class);
	@Drone
	private WebDriver driver;
	@Page
	LoginPage loginPage;
	@Page
	HomePage homePage;
	


	@Test(description = "Login and Logout Flow test", groups= {"smoke","regression","p1","arquillian"},dataProvider = "Authentication")
	public void LoginLogoutFlowTest(String Username, String Password, String expectedLogOutText)  {
		loginPage.loginToApplication(Username, Password);
		log.info("Logged in to application..");
		Assert.assertTrue(homePage.loggedInUserVerification(Username));
		homePage.logOutApplication();
		String actualLogOutText = homePage.getLogoutText();
		Assert.assertEquals(actualLogOutText, expectedLogOutText);
	}
	
	@DataProvider(name = "Authentication")
	public static Object[][] Authentication() {
		return new Object[][] { { "usernane", "password", "You have been logged out." } };
	}
}
