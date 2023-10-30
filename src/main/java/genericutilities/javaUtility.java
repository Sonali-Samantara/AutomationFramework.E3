package genericutilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * this class consists of generic methods related to java
 * @author ssama
 */

public class javaUtility 
{
	/**
	 * This method will generate number for every run and return it to the caller
	 * @return
	 */

	public int getRandomNumber()
	{
	   Random ran=new Random();
	   int r = ran.nextInt(10000);
	   return r;
		
	}
	/**
	 * This method will capture the current system date in required format
	 * @return
	 */
	
	public String getSystemDate1() //
	{
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	    String date = formatter.format(d);
	    return date;
	}
	public String getSystemDate() {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	