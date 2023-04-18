import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
private int  retrycount=1;
private int maxretrycount=20;
	public boolean retry(ITestResult result) {
			if(retrycount<maxretrycount) {
				retrycount++;
				return true;
			}
			return false;
	}
	
}
