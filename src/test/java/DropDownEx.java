

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class DropDownEx {
	WebDriver driver;
	Logger log=(Logger)LogManager.getLogger(DropDownEx.class);

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

	public void main(String[] args) throws Exception {
	
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println("url is opened");

		// drop down
		Select drp = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		List<WebElement> alloptions = drp.getOptions();

		System.out.println("The size is " + alloptions.size());
		for (int i = 0; i < alloptions.size(); i++) {
			System.out.println("Element Text  " + alloptions.get(i).getText());
		}

		// select option
		drp.selectByIndex(1);
		Thread.sleep(2000);
		drp.selectByValue("JAN MAYEN");
		Thread.sleep(2000);
		drp.selectByVisibleText("JERSEY");

		Thread.sleep(2000);
		
	}

}
