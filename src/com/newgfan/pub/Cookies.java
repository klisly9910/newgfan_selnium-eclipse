package com.newgfan.pub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cookies {
	static WebDriver driver;


//	@BeforeMethod
//	public void init() {
//		Driver.getDriver("chrome");
//		driver = new ChromeDriver();
//		driver.get("http://my.gfan.com");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//
//	}

//	@AfterMethod
//	public void close() {
//		driver.close();
//		driver.quit();
//	}

	@Test
	public static void addCookies() {
		//初始化driver,并启动chrome浏览器
		Driver.getDriver("chrome");
		driver = new ChromeDriver();
		driver.get("https://www.zhihu.com/#signin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By
				.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[1]/div[1]/input"));
		username.clear();
		username.sendKeys("txh7279@163.com");
		WebElement password = driver.findElement(By
				.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[1]/div[2]/input"));
		password.clear();
		password.sendKeys("082812ftxh");
		WebElement authCode = driver.findElement(By
				.xpath("//*[@id=\"captcha\"]"));
		authCode.clear();
		BufferedReader readCode = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.println("输入验证码：");
		try {
			authCode.sendKeys(readCode.readLine());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement submit = driver.findElement(By
				.xpath("/html/body/div[1]/div/div[2]/div[2]/form/div[2]/button"));
		submit.click();
		File file = new File("broswer.data");

		try {
			file.delete();
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			BufferedWriter buffer = new BufferedWriter(writer);
			for (Cookie cookie : driver.manage().getCookies()) {
				buffer.write(cookie.getName() + ";" + cookie.getValue() + ";"
						+ cookie.getDomain() + ";" + cookie.getPath() + ";"
						+ cookie.getExpiry() + ";" + cookie.isSecure());
				buffer.newLine();
			}
			buffer.flush();
			buffer.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("cookie write to file");
		}

	}

}
