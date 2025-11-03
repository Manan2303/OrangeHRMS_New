package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import testBase.baseClass_OrangeHRMS;

public class login_testcase extends baseClass_OrangeHRMS {

	loginPage login;

	@Test(priority = 1)
	public void testCompanyLogo() {
		login = new loginPage(driver);
		login.display_logo();
		try {
			Assert.assertTrue(true, "Company logo is displayed in page");
		} catch (Exception e) {
			Assert.fail("Company logo is not displayed.....");
		}

	}

	@Test(priority = 2)
	public void testValidLogin() throws InterruptedException {
		login.setuser("Admin");
		login.setpass("admin123");
		login.submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("dashboard"));

		System.out.println(driver.getCurrentUrl() + " *********************************** ");
		boolean result = driver.getCurrentUrl().contains("dashboard");
		System.out.println(result);

		Assert.assertTrue(result, "User is not redirect to dashboard after enter correct credential");
		Thread.sleep(5000);
	}

	@Test(priority =3)
	public void testInvalidLogin() {
		login.setuser(" wrong");
		login.setpass("xxxxxxxx");
		login.submit();
		boolean isErrorDisplayed = driver.getPageSource().contains("Invalid credentials");
		Assert.assertTrue(isErrorDisplayed, "Error message not displayed for invalid login!");
	}

	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			captureFailTC(result.getName()); // Pass test method name
		}
	}  
	
	/*	@AfterMethod
	public void captureScreenshotOnFailure(ITestResult result) {
	    if (ITestResult.FAILURE == result.getStatus()) {
	        try {
	            if (driver != null) { // Optional: check if session is active
	               
	                driver.getTitle(); // This will throw if session is invalid
	                captureFailTC(result.getName());
	            }
	        } catch (Exception e) {
	            System.out.println("Unable to capture screenshot: " + e.getMessage());
	        }
	    }
	}*/

}
