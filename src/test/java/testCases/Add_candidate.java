package testCases;

import java.time.Duration;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import pageObjects.createCandidate;
import pageObjects.createVaccancy;
import pageObjects.loginPage;
import testBase.baseClass_OrangeHRMS;

public class Add_candidate extends baseClass_OrangeHRMS {

	loginPage lp;
	createVaccancy vac;
	createCandidate Add_cand;


	@Test
	public void addCandidate_test() throws InterruptedException {
		
		logger.info("Create loginPage object Class and very company logo ......");

		lp = new loginPage(driver);
		lp.display_logo();
		try {
			Assert.assertTrue(true, "Company logo is  not displayed in page");
		} catch (Exception e) {
			Assert.fail("Company logo is not displayed.....");
		}
		logger.info("provide user name ........");
		lp.setuser("Admin");
		logger.info("provide user password ........");
		lp.setpass("admin123");
		logger.info("Click submit button for login !!!!!");
		lp.submit();
		
		logger.info("Waiting for 20 sec  to open dashboard bage after successfully login.....");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("dashboard"));

		System.out.println(driver.getCurrentUrl() + " *********************************** ");
		boolean result = driver.getCurrentUrl().contains("dashboard");
		System.out.println(result);

		Assert.assertTrue(result, "User is not redirect to dashboard after enter correct credential");

		// access create Candidate
		logger.info("Call create candidate object class to access.......");
		Add_cand= new createCandidate(driver);
		logger.info("Move to recruitment menu after redirect to dashboard");
		Add_cand.recru_menu();
		logger.info("Open and verify candidate page");
		Add_cand.verify_candidate_page();
		logger.info("input candidate detail in registration page ....");
		Add_cand.cand_data_input("Valmiki","Kumar","Srivastava","priyansh@gmail.com","9616762782","This is for test the script for candidate creation page ");
		Add_cand.submit();


	}
//	@AfterMethod
//	public void captureScreenshotOnFailure(ITestResult result) {
//		if (ITestResult.FAILURE == result.getStatus()) {
//			captureFailTC(result.getName()); // Pass test method name
//		}
//
//	}
	
	@AfterMethod
	
	public void captureScreenshotOnFailure(ITestResult result) {
		logger.info("capture screenshot for test fail....");
		logger.error("Test Failed");
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
	}

}
