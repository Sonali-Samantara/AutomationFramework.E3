package genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This calss will provide implementation to the IRetryAnalyzer interface of testNG
 * @author ssama
 */

public class RetryAnalyserImplemantation implements IRetryAnalyzer {

	int count=0;
	int retryCount=3;
	
	@Override
	public boolean retry(ITestResult result) {
		      //0<3 1<3 2<3 3<3No
		while(count<retryCount)
		{
			count++; //1 2 3
			return true; //retry retry retry
		}
		
		
		
		return false;//stop retrying
	}
	
	
}
