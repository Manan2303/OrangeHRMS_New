package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class addJob extends basePage_HRMS {

	public addJob(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='Admin']")
	WebElement admin_menu;

	@FindBy(xpath = "//span[normalize-space()='Job']")
	WebElement job_opt;


	@FindBy(xpath = "//a[normalize-space()='Job Titles']")
	WebElement job_opt_title;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement job_add_btn;

	@FindBy(xpath = "//h6[normalize-space()='Add Job Title']")
	WebElement addjob_page_title;

	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
	WebElement jobTitle_field;

	@FindBy(xpath = "//textarea[@placeholder='Type description here']")
	WebElement title_description;

	@FindBy(xpath = "//input[@type='file']")
	WebElement UploadJobSpecification;

	@FindBy(xpath = "//textarea[@placeholder='Add note']")
	WebElement note_textArea;
	
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Save_btn;


	// methods 

	public void adminMenu(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(admin_menu)).click();;
		wait.until(ExpectedConditions.elementToBeClickable(job_opt)).click();
		wait.until(ExpectedConditions.elementToBeClickable(job_opt_title)).click();

		wait.until(ExpectedConditions.elementToBeClickable(job_add_btn)).click();

		//         job_add_btn.click();
		System.out.println(" Job tile option click successfully.....");

	}
	public void verifyPage() {
		String pageTitle = addjob_page_title.getText();
		System.out.println(" page title is " + pageTitle);

		boolean result= addjob_page_title.isDisplayed();
		System.out.println(result + " **-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-**-");

		Assert.assertEquals(result, true,"Wrong page is open....");

	}

	public void inputDetails(String job_title,String job_des,String note) {
		jobTitle_field.sendKeys(job_title);
		title_description.sendKeys(job_des);

		// For Upload File 

		System.out.println("Upload Resume Process Start.......");
		String filepath = "C:\\Users\\sriva\\Desktop\\PIC\\test.pdf";
		UploadJobSpecification.sendKeys(filepath);
		System.out.println("upload btn click successfully...");
		System.out.println(filepath);

		note_textArea.sendKeys(note);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void submit() {
		Save_btn.click();
		System.out.println("Job submitted successfully -----------");
		
	}

}
