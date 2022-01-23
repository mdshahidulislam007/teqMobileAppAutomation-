package com.TeqApp.testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public By agreeBtn = By.id("app.ferdia.ferdiadriver.qa:id/agreeButton");
	public By signinBtn = By.id("app.ferdia.ferdiadriver.qa:id/btn_login");
	public By emailField= By.id("username");
	public By ContinueButton1= By.xpath("//button");
	public By Password = By.id("password");
	public By ContinueButton2= By.xpath("//button[@name=\"action\"]");

	public static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Galaxy Tab A7 Lite");
		caps.setCapability("udid", "R8KR50035QP");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "11");
		caps.setCapability("appPackage", "app.ferdia.ferdiadriver.qa");
		caps.setCapability("appActivity", "app.ferdia.ferdiadriver.SplashActivity");
		caps.setCapability("autoGrantPermissions",true);

		
		 /* { "deviceName": "Galaxy Tab A7 Lite", "udid": "R8KR50035QP",
		  "platformName": "Android", "platformVersion": "11", "appPackage":
		  "app.ferdia.ferdiadriver.qa", "appActivity":
		  "app.ferdia.ferdiadriver.SplashActivity" }
		 */

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, caps);
	}

	/*
	 * public void switchToWebview() throws Exception {
	 * 
	 * Set<String> contextNames = driver.getContextHandles();
	 * 
	 * for(String contextName: contextNames) { if(contextName.contains("WEBVIEW")) {
	 * System.out.println("Switching to "+contextName); driver.context(contextName);
	 * }
	 * 
	 * } }
	 * 
	 * public void switchToNative() throws Exception {
	 * 
	 * Set<String> contextNames = driver.getContextHandles();
	 * 
	 * for(String contextName: contextNames) { if(contextName.contains("NATIVE")) {
	 * System.out.println("Switching to "+contextName); driver.context(contextName);
	 * }
	 * 
	 * } }
	 */

	public static void clickElement (By element) throws  Exception{

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait webDriverWait = new WebDriverWait(driver,60);
		webDriverWait.until(ExpectedConditions.elementToBeClickable (element));


		driver.findElement(element).click();
		Thread.sleep(1000);

	}

	public static void verifyElementAndDataEntry(AppiumDriver<MobileElement> driver2, By element,String value) throws Exception {

		boolean elementResult=driver2.findElement(element).isDisplayed();
		clickElement(element);
		driver2.findElement(element).clear();
		if(elementResult==true)
		{
			System.out.println("The ID: " +element+ "element is visible");
		}
		else
		{
			System.out.println("The ID: " +element+ "element is not visible");
		}
		driver2.findElement(element).sendKeys(new String[] { value });


	}
	
	public boolean isPresent(AppiumDriver<MobileElement> driver,By element) throws  Exception{

		
		List<MobileElement> elements=driver.findElements(element);
		if(elements.size()>0) {
			return true;
		}else
		{
			return false;
		}
		

	}
	
}
