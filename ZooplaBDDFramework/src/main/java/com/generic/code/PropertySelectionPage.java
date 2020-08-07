package com.generic.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.PropertyPage;
import com.util.ExplicitWait;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class PropertySelectionPage extends BaseLogin {
	
	public static PropertyPage pf;
	
	public static void enterCityName(WebDriver driver) throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		pf = new PropertyPage(driver);
		new ExplicitWait().getExplicitWait(driver, pf.getSearchlocation());
		pf.getSearchlocation().sendKeys(BaseConfig.getconfig("SearchLocationName"));

		Highlighter.getcolor(driver, pf.getSearchlocation());
		Highlighter.getcolor(driver, pf.getSearchbutton(), "orange");

		TakeAppScreenShot.captureScreenShot(driver, "Search City");
		pf.getSearchbutton().click();

	}
	
	public static void printPrice(WebDriver driver) {
		String[] price;
		List<Integer> intPrice = new ArrayList<>();
		for (int i = 0; i < pf.getHouseprices().size(); i++) {

			price = pf.getHouseprices().get(i).getText().split(" ");
			intPrice.add(Integer.parseInt(price[0].replace("£", "").replaceAll(",", "").trim()));
		}

		System.out.println("House Prices = " + intPrice);
		Collections.sort(intPrice);
		System.out.println("House Prices Sorted ASC Order = " + intPrice);
		Collections.reverse(intPrice);
		System.out.println("House Prices Sorted DESC Order = " + intPrice);

	}
	
	public static void selectProperty(WebDriver driver) {
	Wait.getExplicitWaitVisible(driver, pf.getHouseprices().get(4));
		
		// selecting the 5th property on the page
		pf.getHouseprices().get(4).click();
		
		TakeAppScreenShot.captureScreenShot(driver, "Selected Property");
	}

	public static void verifyAgentInfo(WebDriver driver) throws Throwable {

		if (pf.getPropertylogo().isDisplayed()) {
			System.out.println("Logo is there");
		} else {
			System.out.println("Logo is not there");
		}

		System.out.println("Agent's name = " + pf.getAgentname().getText());
		System.out.println("Agent's phone number = " + pf.getAgentphonenumber().getText());
		TakeAppScreenShot.captureScreenShot(driver, "Agent's Info & Logo");

		Actions signout = new Actions(driver);
		signout.moveToElement(pf.getMyzooplabtn()).build().perform();
		Highlighter.getcolor(driver, pf.getMyzooplabtn(), "lightblue");
		signout.moveToElement(pf.getSignoutbtn()).build().perform();
		Highlighter.getcolor(driver, pf.getSignoutbtn(), "pink");
		TakeAppScreenShot.captureScreenShot(driver, "Sign Out");
		pf.getSignoutbtn().click();

	//	driver.quit();

	}
}