package com.plamenti.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.plamenti.managers.Constants.BrowsersEnum;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

public class WebDriverManager {

	public enum WebDriverEnum {
		INSTACE;

		private WebDriver driver = setupWebDriver();

		public WebDriver getWebDriver() {
			return this.driver;
		}

		public void tearDown() {
			this.driver.quit();
		}

		public WebDriver setupWebDriver() {

			String defaultBrowser = PropertiesManager.getBrowserType();

			switch (BrowsersEnum.valueOf(defaultBrowser)) {
			case chrome:
				ChromeDriverManager.getInstance().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				return new ChromeDriver(options);
			case firefox:
				FirefoxDriverManager.getInstance().setup();
				return new FirefoxDriver();
			case edge:
				EdgeDriverManager.getInstance().setup();
				return new EdgeDriver();
			case ie:
				InternetExplorerDriverManager.getInstance().setup();
				return new InternetExplorerDriver();
			default:
				return null;
			}
		}
	}
}
