package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericutilities.ExcelFileUtility;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtility;
import genericutilities.javaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization 
{

	public static void main(String[] args) throws IOException {
		//step-1: create all the required objets
		
		javaUtility jUtil=new javaUtility();
	    ExcelFileUtility eUtil=new ExcelFileUtility(); 
		PropertyFileUtility pUtil= new PropertyFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		WebDriver driver=null;
		
		//step-2: read the required data
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");		
		
		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//Step-3: Launch the browser
		
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+"launched");
		} 
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"launched");
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER+" launched");
		}
		
		else
		{
			System.out.println("Invalid Browser Name");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		
		//Step=4: Load the URL
		driver.get(URL);
		
		//Step=5: login to the application
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step-6: Navigate to Organizations link
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step-7: Click on create organization look up image
		
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		
		//Step-7: Create organizattions with mandatory information
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step-8: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step-9: Validate
		
		String OrgHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		
		
		if (OrgHeader.contains(ORGNAME)) 
		{
			System.out.println(OrgHeader);
			System.out.println("PASS");
			
		} 
		else 
		{
			System.out.println("FAIL");
		}
		
		//Step 10: Logout of Application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("logout successful");
		
		
	}
	
	
	
}
