package com.newgfan.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newgfan.pub.Driver;

public class FindAllURL {
	WebDriver driver;

	@BeforeMethod
	public void init() {
		Driver.getDriver("chrome");
		driver = new FirefoxDriver();
		driver.get("http://game.gfan.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void close() {
		driver.close();
		driver.quit();
	}

	@Test
	public void findallurl() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of Links in the Page is " + links.size());

		for (int i = 1; i <= links.size() - 1; i = i + 1) {
			System.out.println("Name of Link# " + i + "  "
					+ links.get(i).getAttribute("href"));
		}
		System.out.println("end selenium");

	}

}
