package organizationTests;

import java.io.IOException; //something wrong here....fails while running(i have to chk)

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericutilities.ExcelFileUtility;
import genericutilities.PropertyFileUtility;
import genericutilities.WebDriverUtility;
import genericutilities.javaUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepositary.CreateNewOrganizationPage;
import objectRepositary.HomePage;
import objectRepositary.LogInPage;
import objectRepositary.OrganizationInfoPage;
import objectRepositary.OrganizationsPage;

public class CreateMultipleOrgWithIndustry {

	
	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	javaUtility jUtil = new javaUtility();

	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG, String INDUSTRYNAME) throws IOException, InterruptedException {
		
		WebDriver driver = null;
		
		// Step 2: Read The Required Data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		String ORGNAME = ORG+jUtil.getRandomNumber();

		// Step 3: Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + " launched");
		} else {
			System.out.println("Invalid Browser Name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);

		// Step 4: Load the URL
		driver.get(URL);

		// Step 5: Login To Application
		LogInPage lp = new LogInPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// Step 6: click on Organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 7: Click on Create Organization look Up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();

		// Step 8: Create new Organization with Mandatory fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRYNAME);
		wUtil.captureScreenShot(driver, ORGNAME);

		// Step 9: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		} else {
			System.out.println("FAIL");
		}
		
		//Step 10: Logout
		hp.logoutofApp(driver);
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eUtil.readMultipleData("MultipleOrganizations");

  }
}