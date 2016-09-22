package com.nemo.page.models;

import com.nemo.page.DoOperation;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author ajay.kg created on 21/09/16.
 */
@Slf4j
public class Google {

	WebDriver driver;
	private DoOperation doOperation;

	public Google(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.doOperation = new DoOperation(driver);
	}

	@FindBy(id="lst-ib")
	private WebElement googleSearchBox;

	@FindBy(id="gs_htif0")
	private WebElement googleSearchResultBox;

	@FindBy(linkText = "Sign in")
	private WebElement signInButton;

	public GoogleSignIn clickSignInBtn() {
		log.info("clicking on sign in button");
		if (signInButton.isDisplayed() || signInButton.isEnabled()) {
			doOperation.click(signInButton);
		} else {
			log.error("SIGN IN BUTTON NOT FOUND");
		}
		return new GoogleSignIn(driver);
	}

}
