package com.qa.democart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static String highlight;
	
	private OptionsManager optionsmanager;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize the Driver
	 * 
	 * @param browserName
	 * @return
	 */

	public WebDriver initDriver(Properties prop)

	{

		String browserName = prop.getProperty("browser");
		highlight = prop.getProperty("highlight");

		System.out.println("Browser name is :" + browserName);
		
		optionsmanager = new OptionsManager(prop);
		

		if (browserName.equalsIgnoreCase("chrome"))

		{
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(optionsmanager.getChromeOptions());

		}

		else if (browserName.equalsIgnoreCase("Firefox"))

		{
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver(optionsmanager.getFirefoxOptions());

		}

		else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();

		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get(prop.getProperty("URL"));

		return driver;

	}

	/**
	 * This method is used to intializae the properties on the basis of given env
	 * name
	 * 
	 * @return
	 */

	public Properties initProperties()

	{
		Properties prop = null;
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return prop;

	}

}
