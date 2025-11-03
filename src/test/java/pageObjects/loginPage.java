package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage_HRMS{

	public loginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	// locator 
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath = "//img[@alt='company-branding']")
	WebElement comp_logo;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement submit_btn;
	
	//Actions Method
	
	public void setuser(String user) {
		username.sendKeys(user);
		System.out.println("user name successfully entered" + " " + user);
	}
	
	public void setpass(String pwd) {
		password.sendKeys(pwd);
		System.out.println("user password successfully entered" + " " +  pwd);
	}
	public void submit() {
		
		submit_btn.click();
		System.out.println("Submit the credential successfully...........");
	}
	
	public void display_logo() {
		System.out.println("Website is successfully open......");
		if(comp_logo.isDisplayed()) {
		
		}
		
	}
}

