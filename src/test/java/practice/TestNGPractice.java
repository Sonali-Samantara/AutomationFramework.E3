package practice;

import org.testng.annotations.Test;

public class TestNGPractice {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	@Test(invocationCount = 5 , priority = 9 )
	public void createCustomer()
	{
		System.out.println("created");
	}

	@Test(priority =4 )
	public void modifyCustomer()
	{
		System.out.println("modified");
	}

	@Test(priority = 2)
	public void DeleteCustomer()
	{
		System.out.println("deleteded");
	}

	
}
