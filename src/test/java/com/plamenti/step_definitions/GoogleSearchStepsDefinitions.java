package com.plamenti.step_definitions;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;

import com.plamenti.managers.WebDriverManager;

import Pages.GoogleSearchPage;

public class GoogleSearchStepsDefinitions {
	WebDriver driver;
	GoogleSearchPage googleSearchPage;

	public GoogleSearchStepsDefinitions() {
		this.driver = WebDriverManager.WebDriverEnum.INSTACE.getWebDriver();
		this.googleSearchPage = new GoogleSearchPage(this.driver);
	}

	@AfterStories
	public void tearDown() {
		this.driver.quit();
	}

	@Given("navigate to google")
	public void navigateToGoogle() {
		this.googleSearchPage.navigate();
	}

	@When("type some $text in search field and press enter")
	public void searchInGoogle(String text) {
		this.googleSearchPage.searchForText(text);
	}

	@Then("result from search is present")
	public void verifyResult() {
		this.googleSearchPage.verifySearchResult();
	}
}
