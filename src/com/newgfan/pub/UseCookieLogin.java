package com.newgfan.pub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;

public class UseCookieLogin {
	static WebDriver driver;

	public static void main(String[] args) {
		Cookies.addCookies();
		// kill chrome
		WindowsUtils.tryToKillByName("chrome.exe");
		WindowsUtils.getProgramFilesPath();
		Driver.getDriver("chrome");
		driver = new ChromeDriver();
		driver.get("https://www.zhihu.com");
		driver.manage().window().maximize();

		try {
			File file = new File("broswer.data");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			try {
				while ((line = br.readLine()) != null) {
					StringTokenizer str = new StringTokenizer(line, ";");
					while (str.hasMoreTokens()) {
						String name = str.nextToken();
						String value = str.nextToken();
						String domain = str.nextToken();
						String path = str.nextToken();
						Date expiry = null;
						String dt;
						if (!(dt = str.nextToken()).equals(null)) {
							// expiry=new Date(dt);
							System.out.println();
						}
						boolean isSecure = new Boolean(str.nextToken())
								.booleanValue();
						Cookie ck = new Cookie(name, value, domain, path,
								expiry, isSecure);
						driver.manage().addCookie(ck);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
