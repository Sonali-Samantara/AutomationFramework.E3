package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {

	@Test(retryAnalyzer=genericutilities.RetryAnalyserImplemantation.class)
	public void analyserPractice()
	{
		Assert.fail();
		System.out.println("HI");
	}
}
