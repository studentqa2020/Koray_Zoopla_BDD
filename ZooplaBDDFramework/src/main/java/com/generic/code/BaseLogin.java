package com.generic.code;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class BaseLogin {
	
	public static LoginPage login;
	
	public static WebDriver setupBrowser() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(BaseConfig.getconfig("URL"));
		login =new LoginPage(driver);
		System.out.println(driver.getTitle());
		
		login.getCookies().click();
		login.getLogin().click();
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());		

		return driver;
	}
	
	public static void enterCredentials(WebDriver driver) throws Throwable {
		Wait.getExplicitWaitClicable(driver, login.getEmail());
		new Highlighter().getcolor(driver, login.getEmail(), "yellow");
		login.getEmail().sendKeys(BaseConfig.getconfig("email"));
		
		new Highlighter().getcolor(driver, login.getPass(),"yellow");
		login.getPass().sendKeys(BaseConfig.getconfig("pass"));
		Thread.sleep(2500);
		login.getSubmit().click();
		System.out.println(driver.getTitle());
		TakeAppScreenShot.captureScreenShot(driver, "Login success");
		
		//driver.quit();
	}	
	
	public static void userSignedIn(WebDriver driver) {
		System.out.println(driver.getTitle());
	}

}