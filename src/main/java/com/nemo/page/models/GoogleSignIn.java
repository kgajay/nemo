package com.nemo.page.models;

import com.nemo.page.DoOperation;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.nemo.utils.WebDriverUtils.waitForWebElementToAppear;

/**
 * @author ajay.kg created on 21/09/16.
 */
@Slf4j
public class GoogleSignIn {

	WebDriver driver;
	private DoOperation doOperation;

	public GoogleSignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.doOperation = new DoOperation(driver);
	}

	@FindBy(id="Email")
	private WebElement email;

	@FindBy(id="next")
	private WebElement next;

	@FindBy(id="Passwd")
	private WebElement password;

	@FindBy(id="signIn")
	private WebElement signIn;

	@FindBy(css=".hidden-small")
	private WebElement headerPageText;

	@FindBy(id="link-signup")
	private WebElement createAccountLink;

	@FindBy(id="errormsg_0_Passwd")
	private WebElement errorMsgTxt;

	@FindBy(linkText = "Gmail")
	private WebElement gmailLink;

	public String getSignInPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public boolean verifySignInPageTitle() {
		String expectedTitle = "Sign in - Google Accounts";
		return getSignInPageTitle().contains(expectedTitle);
	}

	public boolean verifySignInPageText() {
		String pageText = headerPageText.getText();
		String expectedPageText = "Sign in with your Google Account";
		return pageText.contains(expectedPageText);
	}

	public boolean verifySignIn(String user, String pass) {
		enterUserName(user);
		waitForWebElementToAppear(driver, By.id("Passwd"), 10);
		enterPassword(pass);
		clickOnSignIn();
		clickOnGmail();
		return true; // getErrorMessage().contains("incorrect");
	}

	public void enterUserName(String userName) {
		if(email.isDisplayed() && next.isDisplayed()) {
			doOperation.type(email, userName);
			doOperation.click(next);
		}
	}

	public void enterPassword(String passwd) {
		if(password.isDisplayed()) {
			doOperation.type(password, passwd);
		}
	}

	public void clickOnSignIn() {
		if(signIn.isDisplayed()) {
			doOperation.click(signIn);
		}
	}

	public void clickOnGmail() {
		if(gmailLink.isDisplayed()) {
			doOperation.click(gmailLink);
		}
	}

	public String getErrorMessage() {
		String strErrorMsg = null;
		if(errorMsgTxt.isDisplayed() && errorMsgTxt.isEnabled()) {
			strErrorMsg = errorMsgTxt.getText();
		}
		return strErrorMsg;
	}
}
