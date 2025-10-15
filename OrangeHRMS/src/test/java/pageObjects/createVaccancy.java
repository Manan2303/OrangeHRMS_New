package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class createVaccancy extends basePage_HRMS {

	public createVaccancy(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// Locator

	// Add Vacancy
	@FindBy(xpath = "//span[normalize-space()='Recruitment']")
	WebElement recrut_menu;

	@FindBy(xpath = "//a[normalize-space()='Vacancies']")
	WebElement vacancy;

	@FindBy(xpath = "//button[normalize-space()='Add']")
	WebElement add_btn;

	@FindBy(xpath = "//h6[normalize-space()='Add Vacancy']")
	WebElement page_text;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement vaccancy_name;

	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	WebElement job_title_dd;

	@FindBy(xpath = "//div[contains(@class,'oxd-select-text-input') and contains(text(),'Automaton Tester')]")
	WebElement dropdown_value;

	@FindBy(xpath = "//textarea[@placeholder='Type description here']")
	WebElement descriptionArea;

	@FindBy(xpath = " //input[@placeholder='Type for hints...']")
	WebElement HM;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement NoOFPos;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save_vacancy;

	// Method

	public void recru_menu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(recrut_menu)).click();
		System.out.println("Recrutiment menu click successfully ....");

		wait.until(ExpectedConditions.visibilityOf(vacancy)); // waits till vaccancy option is displayed
		vacancy.click();

		wait.until(ExpectedConditions.elementToBeClickable(add_btn)).click();
		System.out.println("Add vaccancy button click successfully");
	}

	public void verifyPage() {
		boolean text_visible = page_text.isDisplayed();
		String res_page = page_text.getText();
		System.out.println(res_page);
		System.out.println(text_visible);

		Assert.assertTrue(text_visible, "Add vacancy page is not open");

	}

	public void input_details() {
		vaccancy_name.sendKeys("Test Automation Engineer ll");
		job_title_dd.click();
//		dropdown_value.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Value select in dd successfully..........");
		descriptionArea.sendKeys(
				" We are looking for a highly skilled and motivated Automation Test Engineer with expertise in Selenium and Java to join our Quality Assurance team. The ideal candidate will be responsible for designing, developing, and maintaining robust automation frameworks to ensure the quality and reliability of web applications. You will collaborate closely with developers, QA analysts, and product managers to deliver high-performing software solutions.");
		NoOFPos.sendKeys("10");

	}

	public void submit() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(save_vacancy)).click();
		System.out.println("Vaccancy created successfully");
	}

}
