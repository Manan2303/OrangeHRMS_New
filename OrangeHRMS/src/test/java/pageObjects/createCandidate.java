package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class createCandidate extends basePage_HRMS {

	public createCandidate(WebDriver driver) {
		super(driver);
		
	}

	// Locator
	@FindBy(xpath = "//span[normalize-space()='Recruitment']")
	WebElement recrut_menu;

	@FindBy(xpath = "//a[normalize-space()='Candidates']")
	WebElement Candidates;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement add_candidate;

	@FindBy(xpath = "//h6[normalize-space()='Add Candidate']")
	WebElement cand_text;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement F_Name;

	@FindBy(xpath = "//input[@placeholder='Middle Name']")
	WebElement Mid_Name;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement L_Name;

//	@FindBy(xpath = "///div[@class='oxd-select-text oxd-select-text--active']")
//	WebElement vac_DD;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")
	WebElement email;

	@FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
	WebElement contact;

	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadResume;

	@FindBy(xpath = "//textarea[@placeholder='Type here']")
	WebElement notes;

	@FindBy(xpath = "//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
	WebElement consent_checkBox;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;

	// Action
	public void recru_menu() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(recrut_menu)).click();
		wait.until(ExpectedConditions.elementToBeClickable(add_candidate)).click();
		System.out.println("Add Candidate Button Click Successfully .....");
	}

	public void verify_candidate_page() {
		boolean result = cand_text.isDisplayed();
		String res_page = cand_text.getText();
		System.out.println(result);
		System.out.println(res_page);

		Assert.assertTrue(result, "Add candidate page is not open");
	}

	public void cand_data_input(String f_name, String M_name, String L_name, String Email, String phn, String note)
			throws InterruptedException {
		F_Name.sendKeys(f_name);
		Mid_Name.sendKeys(M_name);
		L_Name.sendKeys(L_name);
		email.sendKeys(Email);
		contact.sendKeys(phn);
		System.out.println(f_name + M_name + L_name + " is the name of candidate");

		System.out.println("Upload Resume Process Start.......");
		String filepath = "C:\\Users\\sriva\\Desktop\\PIC\\test.pdf";
		uploadResume.sendKeys(filepath);
		System.out.println("upload btn click successfully...");
		System.out.println(filepath);

		Thread.sleep(5000);
		notes.sendKeys(note);

		Thread.sleep(15000);

	}



	public void submit() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(save)).click();

		System.out.println("Candidate form Submitted successfully");

	}

}
