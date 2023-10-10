package reExeuter;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	public static int retryCount = 0;
	private static final int maxCount = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(retryCount < maxCount) {
			retryCount++;
			return true;
		}
		return false;
	}
}
