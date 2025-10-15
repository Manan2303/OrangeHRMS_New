package testBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseClass_OrangeHRMS {
	public WebDriver driver;

	@BeforeClass
	public void test() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println(driver.getTitle());

		
//		System.out.println(driver.getCurrentUrl() + " /////////////////////////////////////////");

	}

	@AfterClass
	public void teardown() {
		System.out.println("Browser is now closing");
		driver.quit();
	}

	// Capture screenshot on failure
	public void captureFailTC(String testName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);

		// Add timestamp to avoid overwriting
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File destination = new File("C:\\Users\\sriva\\eclipse-workspace-new\\OrangeHRMS\\bugs_screenShots\\" + testName
				+ "_" + timestamp + ".png");

		try {
//			Files.copy(source, destination)
			Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("❌ Screenshot captured for failed test: " + destination.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
