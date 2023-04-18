package WebDriver_Commands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Browser_Specific_Commands {
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
	public void Commands() {
		driver.get("https://opensource-demo.orangehrmlive.com/");/// opens url
		String title = driver.getTitle();/// Gets Title
		System.out.println("Title of the Page is :" + title);
		String currenturl = driver.getCurrentUrl();/// Gets Currenttitle
		System.out.println("current url is :" + currenturl);
		String pgs = driver.getPageSource();/// Gets PageSource
		System.out.println(pgs);
	}

}
