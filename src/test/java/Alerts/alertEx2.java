package Alerts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class alertEx2 {
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

	public  void alerts2() {
		
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("1234");

		driver.findElement(By.xpath("//input[@name='submit']")).click();
		driver.switchTo().alert();
		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("the text is:" + text);
		
	}

}
