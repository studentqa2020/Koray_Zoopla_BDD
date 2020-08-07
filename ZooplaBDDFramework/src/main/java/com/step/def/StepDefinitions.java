package com.step.def;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.generic.code.BaseLogin;
import com.generic.code.PropertySelectionPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	
	public WebDriver driver;
	
	@Given("Setup Browser and pass URL")
	public void setup_Browser_and_pass_URL() throws Throwable {
	    driver = BaseLogin.setupBrowser();
	}

	@When("user enter username password and submit")
	public void user_enter_username_password_and_submit() throws Throwable {
	    BaseLogin.enterCredentials(driver);
	}

	@When("User get the home page")
	public void user_get_the_home_page() {
	    BaseLogin.userSignedIn(driver);
	}

	@When("user enter city name and search")
	public void user_enter_city_name_and_search() throws Throwable {
	    PropertySelectionPage.enterCityName(driver);
	}

	@When("user print prices in desc order")
	public void user_print_prices_in_desc_order() {
	    PropertySelectionPage.printPrice(driver);
	}
	
	@When("User select property")
	public void user_select_property() {
	    PropertySelectionPage.selectProperty(driver);
	}

	@Then("user verify Agent logo name phone num and logout")
	public void user_verify_Agent_logo_name_phone_num_and_logout() throws Throwable {
	   PropertySelectionPage.verifyAgentInfo(driver);
	}




	
/*	WebDriver driver;
	@Given("User is already on Login Page")
	public void user_is_already_on_Login_Page() throws Throwable {
	    driver = BaseLogin.getLogin();
		//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		//driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("https://www.zoopla.co.uk/");
		//driver.manage().deleteAllCookies();
		//driver.findElement(By.xpath("(//*[@type='button'])[2]")).click();
		
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() throws Throwable {
		BaseLogin.enterCredentials(driver);
		//driver.findElement(By.xpath("((//*[@class='css-fa8dvy e11d441i1'])[4]")).click();
		//driver.findElement(By.xpath("//*[@name='signin_email']")).sendKeys("sarikayakoray@hotmail.com");
		//driver.findElement(By.xpath("//*[@name='signin_password']")).sendKeys("smarttech");
	}

	@When("User clicks on Sign In button")
	public void user_clicks_on_sign_in_button() {
		//driver.findElement(By.xpath("//*[@id='signin_submit']")).click();
		BaseLogin.clickLoginIn(driver);
	}

	@Then("User is logged in")
	public void user_is_logged_in() {
		//boolean link = driver.findElement(By.linkText("MyZoopla")).isDisplayed();
		BaseLogin.userSignedIn(driver);
	}
*/

}
