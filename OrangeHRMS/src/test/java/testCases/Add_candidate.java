package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
		
		lp = new loginPage(driver);
		lp.display_logo();
		try {
			Assert.assertTrue(true, "Company logo is  not displayed in page");
		} catch (Exception e) {
			Assert.fail("Company logo is not displayed.....");
		}
		
		lp.setuser("Admin");
		lp.setpass("admin123");
		lp.submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("dashboard"));

		System.out.println(driver.getCurrentUrl() + " *********************************** ");
		boolean result = driver.getCurrentUrl().contains("dashboard");
		System.out.println(result);

		Assert.assertTrue(result, "User is not redirect to dashboard after enter correct credential");
		
		 // access create Candidate
		Add_cand= new createCandidate(driver);
		Add_cand.recru_menu();
		Add_cand.verify_candidate_page();
		Add_cand.cand_data_input("Priyansh","Kumar","Srivastava","priyansh@gmail.com","9616762782","Testing Purpose for .......................");
//		Add_cand.upload();
		Add_cand.submit();
	}
	

}
