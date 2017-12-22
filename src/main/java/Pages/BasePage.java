package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	public void navigateTo(String url) {
		this.getDriver().get(url);
	}

	private void enterValueInWebElement(WebElement textField, String value, String key) {
		textField.click();
		textField.clear();

		if (key != null) {
			String uppercase = key.toUpperCase();
			textField.sendKeys(value, Keys.valueOf(uppercase));
		} else {
			textField.sendKeys(value);
		}
	}

	public void enterTextInField(WebElement element, String text) {
		enterValueInWebElement(element, text, null);
	}

	public void enterTextInFieldAndPressKey(WebElement element, String value, String key) {
		enterValueInWebElement(element, value, key);
	}

	public String getValue(WebElement element) {
		return element.getText();
	}
}
