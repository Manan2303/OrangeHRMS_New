package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.createVaccancy;
import pageObjects.loginPage;
import testBase.baseClass_OrangeHRMS;

public class createVacancy_TC extends baseClass_OrangeHRMS {

	loginPage lp;
	createVaccancy vac;

	@Test
	public void addVacancy_test() {

		// login page
		lp = new loginPage(driver);

		lp.display_logo();
		try {
			Assert.assertTrue(true, "Company logo is displayed in page");
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

		// access create Vacancy
		vac = new createVaccancy(driver);
		vac.recru_menu();
		vac.verifyPage();
		vac.input_details();
		vac.submit();

	}

}
