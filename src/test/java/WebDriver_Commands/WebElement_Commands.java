package WebDriver_Commands;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebElement_Commands {
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
	public void WebElement() throws Exception {

		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("username")).clear();
		boolean d = driver.findElement(By.name("username")).isDisplayed();
		boolean e = driver.findElement(By.name("username")).isEnabled();
		boolean s = driver.findElement(By.name("username")).isSelected();
		String a = driver.findElement(By.name("username")).getAttribute("name");
		Dimension size = driver.findElement(By.name("username")).getSize();
		String tagname = driver.findElement(By.name("username")).getTagName();
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		System.out.println(d);
		System.out.println(e);
		System.out.println(s);
		System.out.println(a);
		System.out.println(size);
		System.out.println(tagname);

	}

}
