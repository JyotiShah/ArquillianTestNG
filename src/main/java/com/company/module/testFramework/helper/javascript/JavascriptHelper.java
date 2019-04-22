package com.company.module.testFramework.helper.javascript;

import org.apache.log4j.Logger;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.company.module.testFramework.helper.logger.Log;

public class JavascriptHelper {
	private final static Logger log = Log.getLogger(JavascriptHelper.class);
	@ArquillianResource
	JavascriptExecutor exe;

	/**
	 * This method will execute java script
	 * 
	 * @param script
	 * @return
	 */
	public Object executeScript(String script) {
		return exe.executeScript(script);
	}

	/**
	 * This method will execute Java script with multiple arguments
	 * 
	 * @param script
	 * @param args
	 * @return
	 */
	public Object executeScript(String script, Object... args) {
		return exe.executeScript(script, args);
	}

	/**
	 * This method will scroll till element
	 * 
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		log.info("scroll to WebElement...");
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
	}

	/**
	 * Scroll till element and click
	 * 
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("element is clicked: " + element.toString());
	}

	/**
	 * Scroll till element view
	 * 
	 * @param element
	 */
	public void scrollIntoView(WebElement element) {
		log.info("scroll till web element");
		executeScript("arguments[0].scrollIntoView()", element);
	}

	/**
	 * Scroll till element view and click
	 * 
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("element is clicked: " + element.toString());
	}

	/**
	 * This method will scroll down vertically
	 */
	public void scrollDownVertically() {
		log.info("scrolling down vertically...");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/**
	 * This method will scroll up vertically
	 */
	public void scrollUpVertically() {
		log.info("scrolling up vertically...");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}

	/**
	 * This method will scroll till given pixel (e.g=1500)
	 * 
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel) {
		executeScript("window.scrollBY(0," + pixel + ")");
	}

	public void scrollUpByPixel(int pixel) {
		executeScript("window.scrollBY(0,-" + pixel + ")");
	}

	/**
	 * This method will zoom screen by 100%
	 */
	public void zoomInBy100Percentage() {
		executeScript("document.body.style.zoom='100%'");
	}

	/**
	 * This method will zoom screen by 60%
	 */
	public void zoomInBy60Percentage() {
		executeScript("document.body.style.zoom='60%'");
	}

	/**
	 * This method will click on element
	 * 
	 * @param element
	 */
	public void clickElement(WebElement element) {
		exe.executeScript("arguments[0].click();", element);
		log.info("Clicking on element: " + element);
	}

	public void sendKeys(Keys value) {
		executeScript("keyDown(Keys.value)");
		log.info("Enterred values : " + value);
	}

}
