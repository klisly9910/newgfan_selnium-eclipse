package com.newgfan.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newgfan.elements.MainPageElements;
import com.newgfan.pub.Driver;
import com.newgfan.pub.SwitchToWindow;

public class TestMainPage {
	WebDriver driver;

	@BeforeMethod
	public void init() {
		Driver.getDriver("firefox");
		driver = new FirefoxDriver();
		driver.get("http://www.gfan.com/new/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}

	@Test
	public void TouTiao() {
		MainPageElements mainPage = PageFactory.initElements(driver,
				MainPageElements.class);
		 String title = mainPage.fengTouTiao.getText();
		 Assert.assertEquals(title, "锋头条");

//		String titleTex = mainPage.toutiaoTitle.getAttribute("href");
//		mainPage.toutiaoTitle.click();
//		SwitchToWindow.switchToWindow(driver);
//		Assert.assertEquals(
//				SwitchToWindow.window.getCurrentUrl().substring(
//						SwitchToWindow.window.getCurrentUrl().indexOf("//")),
//				titleTex.substring(titleTex.indexOf("//")));

	}

}
