package com.newgfan.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageElements {
	WebDriver driver;

    //构造方法（有参数
    public MainPageElements(WebDriver driver) {
        this.driver = driver;
        // driver.get(url);
        // PageFactory.initElements(driver, this);
    }
    //锋头条
    @FindBy(xpath = "html/body/div[3]/div[2]/div[2]/h1")
    public WebElement fengTouTiao;

    @FindBy(xpath = "html/body/div[3]/div[2]/div[2]/div[1]/ul/li[2]/a")
    public WebElement toutiaoTitle;
	

}
