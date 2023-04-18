package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Checkbox_Radiobtn {
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
	public void Radiobtn() throws Exception {
		driver.get("https://www.automationtestinginsider.com/2019/08/student-registration-form.html");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Singing']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Dancing']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Sketching']")).click();
		Thread.sleep(3000);
	}

}
