package practice;

import java.io.IOException;

import genericutilities.ExcelFileUtility;
import genericutilities.PropertyFileUtility;
import genericutilities.javaUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil=new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("username");
		System.out.println(value);
		
		String Browser = pUtil.readDataFromPropertyFile("browser");
	    System.out.println(Browser);
	
	    ExcelFileUtility eUtil=new ExcelFileUtility();
	    String data = eUtil.readDataFromExcel("Organization", 4, 2);
	    System.out.println(data);
	
	    javaUtility jUtil=new javaUtility();
	    int r = jUtil.getRandomNumber();
	    System.out.println(r); //every time we run random numbers will be generated
	
	    String date = jUtil.getSystemDate1();
	    System.out.println(date);
	
	
	}

}

