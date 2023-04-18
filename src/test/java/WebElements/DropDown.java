package WebElements;

import java.util.List;

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
import org.testng.annotations.Test;

public class DropDown {
	WebDriver driver;

	@BeforeMethod
	@Parameters(value = "browser")
	public void launchbrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

	@Test
	public void DropDownmenu() throws Exception {

		driver.get("https://www.automationtestinginsider.com/2019/08/student-registration-form.html");

		WebElement day = driver.findElement(By.id("Birthday_Day"));
		WebElement month = driver.findElement(By.id("Birthday_Month"));
		WebElement year = driver.findElement(By.id("Birthday_Year"));
		Select d = new Select(day);
		Select m = new Select(month);
		Select y = new Select(year);
		d.selectByIndex(1);
		Thread.sleep(2000);
		m.selectByValue("January");
		Thread.sleep(2000);
		y.selectByVisibleText("1999");
		Thread.sleep(2000);
		List<WebElement> li = m.getOptions();
		System.out.println(li);

	}
}
