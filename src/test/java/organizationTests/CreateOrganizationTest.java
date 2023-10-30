package organizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericutilities.ExcelFileUtility;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtility;
import genericutilities.javaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {
	@Test
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

        //Step=5 :

	}

}
