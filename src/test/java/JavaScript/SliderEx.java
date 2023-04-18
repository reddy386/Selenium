package JavaScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SliderEx {
	WebDriver driver;

	@BeforeMethod
	@Parameters(value="browser")
	public void launchbrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

	@Test
	public void slider() {

		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bluetooth speakers");
		driver.findElement(By.id("nav-search-submit-button")).click();

		// java script scroll up or scroll down
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("window.scrollBy(0,-1000)");

	}

}
