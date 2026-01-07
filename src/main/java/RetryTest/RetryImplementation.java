package RetryTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer{
	
	public static int retryCount = 0;
	public static final int  maxCount = 5;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(retryCount<maxCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
