package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import genericutilities.ExcelFileUtility;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtility;
import genericutilities.javaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepositary.ContactInfoPage;
import objectRepositary.ContactsPage;
import objectRepositary.CreateNewContactPage;
import objectRepositary.CreateNewOrganizationPage;
import objectRepositary.HomePage;
import objectRepositary.LogInPage;
import objectRepositary.OrganizationInfoPage;
import objectRepositary.OrganizationsPage;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws IOException, InterruptedException {

		//step-1: create all the required objects

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

		String ORGNAME = eUtil.readDataFromExcel("Organization", 7, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);

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

		//Step-5: login to the application
		LogInPage lp=new LogInPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		//Step-6: Click on organization
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();

		//Step-7:Click on create Organization look up image
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();

		//Step-8: Create new organization with mandatory fields
		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);

		//Step-9: validate for organization 
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		if (orgHeader.contains(ORGNAME)) 
		{
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		} 
		else 
		{
			System.out.println("FAIL");
		}

		//Step-10: click on contacts link
		hp.clickOnContactsLink();

		//Step-11: Click on create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactPageImg();

		//Step-12: create contact with organization
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);

		//Step-13: Validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);

		//Step-14:LogOut
		hp.logoutofApp(driver);

		//Step-15:Close the Browser
		driver.quit(); 

	}
}
