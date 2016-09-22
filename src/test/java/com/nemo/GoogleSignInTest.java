package com.nemo;

import com.google.common.base.Strings;
import com.nemo.page.models.Google;
import com.nemo.page.models.GoogleSignIn;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author ajay.kg created on 21/09/16.
 */
@Slf4j
@NoArgsConstructor
public class GoogleSignInTest extends BaseTestSetup {

	private WebDriver driver;
	String appURL = "http://www.google.com";
	private String userName;
	private String password;

	@BeforeMethod
	public void setUp() {
		driver=getDriver();
	}

	public GoogleSignInTest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Test(enabled = false)
	public void verifyGooglePageTittle() {
		log.info("Starting test verifyGooglePageTittle");
		driver.navigate().to(appURL);
		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, "Google");
		GoogleSignIn signIn = new GoogleSignIn(driver);
		signIn.verifySignInPageText();
	}

	@Test(enabled = true)
	public void verifySignInFunction() {
		log.info("Sign In functionality details... USER: {}, PASSWORD: {}", userName, password);
		if (Strings.isNullOrEmpty(userName) || Strings.isNullOrEmpty(password)) {
			log.info("USER or PASSWORD IS NULL");
		} else {
			Google basePage = new Google(driver);
			GoogleSignIn signInPage = basePage.clickSignInBtn();
			signInPage.verifySignIn(userName, password);
		}

	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
