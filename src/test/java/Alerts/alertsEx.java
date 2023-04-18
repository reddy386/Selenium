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
import org.testng.annotations.Test;

public class alertsEx {
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
	public void alerts() {

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		///// js alert with ok button....................
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		String text1 = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("The Test is:" + text1);
		System.out.println("The Test is:" + text);

		/////// js alert with ok and cancel button

		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		text1 = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("The Test is:" + text1);
		System.out.println("The Test is:" + text);

		///// js prompt
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		text1 = driver.switchTo().alert().getText();
		driver.switchTo().alert().sendKeys("Yashwanth");
		driver.switchTo().alert().accept();
		text = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println("The Test is:" + text1);
		System.out.println("The Test is:" + text);

	}

}
