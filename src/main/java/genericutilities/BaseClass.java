package genericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepositary.HomePage;
import objectRepositary.LogInPage;

/**
 * This class consists of all basic configuration Annotations of tstNG
 * 
 * @author s.sama
 */

public class BaseClass {

	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public javaUtility jUtil=new javaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public WebDriver driver=null;
	
	public static WebDriver sdriver;//creating a separate variable for listeners 
	
	@BeforeSuite(groups={"SmokeSuite","ReggressionSuite"})
	public void bsConfig()
	{
		System.out.println("---- DB Connection Successful----");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
	
	    if (BROWSER.equalsIgnoreCase("chrome")) 
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
			System.out.println(BROWSER + "----launched----");
		} 
	    
	    else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    	System.out.println(BROWSER + "----launched----");	
		}
	    
	    else if(BROWSER.equalsIgnoreCase("Edge")) 
	    {
	    	WebDriverManager.edgedriver().setup();
	    	driver=new EdgeDriver();
	    	System.out.println(BROWSER + "----launched----");
	    }
		
	    else
	    {
	    	System.out.println("Invalid Browser Name");
	    }
	
	    wUtil.maximizeWindow(driver);
	    wUtil.waitForPageLoad(driver);
	    
	    //sdriver ans driver are same ..but sdriver is static in nature
	    //sdriver used in Listeners
	    sdriver=driver;
	    
	    driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		
		LogInPage lp= new LogInPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("----Login Successful----");
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		hp.logoutofApp(driver);
		
		System.out.println("----Logout Succesful----");
		
	}
	
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("----Browser Closed----");
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("----DB Connection Closed----");
	}
		
}
