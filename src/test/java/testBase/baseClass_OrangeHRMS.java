package testBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class baseClass_OrangeHRMS {
	public WebDriver driver;
	public Logger logger;

	@Parameters({"os","browser","url"})
	@BeforeClass
	public void test(String os, String br,String URL) {
		logger= LogManager.getLogger(this.getClass());
		switch(br.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		default:
			System.out.println("Invalid Choice");
			return;
		}
		driver.manage().deleteAllCookies();
		driver.get(URL);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		System.out.println(driver.getTitle());


		//		System.out.println(driver.getCurrentUrl() + " /////////////////////////////////////////");

	}

	//	@AfterClass
	//	public void teardown() {
	//		System.out.println("Browser is now closing");
	//		driver.quit();
	//	}

	// Capture screenshot on failure
	public void captureFailTC(String testName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);

		// Add timestamp to avoid overwriting
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String desig_path = "C:\\Users\\sriva\\git\\repository\\OrangeHRMS\\bugs_screenShots\\";
		File destination = new File(desig_path+ testName + "_" + timestamp + ".png");

		try {

			Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("❌ Screenshot captured for failed test: " + destination.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
