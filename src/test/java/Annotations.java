import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Annotations {
	@org.testng.annotations.BeforeSuite
	public void BeforeSuite() {
		System.out.println("this is simpleBeforeSuite example");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("this is simple before class example");
	}
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		System.out.println("this is simple before Method example");
	}
	@Test
	public void TestCase1() {
		System.out.println("This is testcase 1 example");
	}
	@Test
	public void TestCase2() {
		System.out.println("This is testcase 1 example");
	}
	@Test(priority=1,invocationCount=3,description="normal test case",enabled=true,dependsOnMethods= "TestCase4()" )
	public void TestCase3() {
		System.out.println("This is testcase 1 example");
	}
	@Test
	public void TestCase4() {
		System.out.println("This is testcase 1 example");
	}
	@Test
	public void TestCase5() {
		System.out.println("This is testcase 1 example");
	}
	
	
	@org.testng.annotations.AfterMethod
	public void AfterMethod() {
		System.out.println("this is simple After Method example");
	}
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		System.out.println("this is simple After class example");
	}
	@org.testng.annotations.AfterSuite
	public void AfterSuite() {
		System.out.println("this is simple Aftersuite example");
	}
	

}
