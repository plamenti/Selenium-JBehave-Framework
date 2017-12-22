package Pages;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.plamenti.managers.PropertiesManager;

public class GoogleSearchPage extends BasePage {

	private final String url = PropertiesManager.getPageProperty("GoogleUrl");

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getSearchField() {
		return this.getDriver().findElement(By.name("q"));
	}

	public List<WebElement> getSearchResults() {
		return this.getDriver().findElements(By.className("g"));
	}

	public void navigate() {
		this.navigateTo(url);
	}

	public void searchForText(String text) {
		this.enterTextInField(this.getSearchField(), text);
		this.getSearchField().sendKeys(Keys.ENTER);
	}

	public void verifySearchResult() {

		assertTrue(getSearchResults().size() > 0);

	}
}
