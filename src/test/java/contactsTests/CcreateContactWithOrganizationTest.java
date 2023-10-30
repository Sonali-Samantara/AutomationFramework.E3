package contactsTests;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import objectRepositary.ContactInfoPage;
import objectRepositary.ContactsPage;
import objectRepositary.CreateNewContactPage;
import objectRepositary.CreateNewOrganizationPage;
import objectRepositary.HomePage;
import objectRepositary.OrganizationInfoPage;
import objectRepositary.OrganizationsPage;

public class CcreateContactWithOrganizationTest extends BaseClass {

	@Test(groups="ReggressionSuite")
	public void createContactWithOrganizationTest() throws InterruptedException, IOException 
	{
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 7 , 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 7, 2);
		
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
			Assert.assertTrue(orgHeader.contains(ORGNAME));
			System.out.println(orgHeader);
			
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
			Assert.assertTrue(orgHeader.contains(ORGNAME));
			System.out.println(orgHeader);
			Assert.assertTrue(orgHeader.contains(LASTNAME));
			System.out.println(contactHeader);
			
			//Step-14:LogOut
			hp.logoutofApp(driver);
			
			//Step-15:Close the Browser
			driver.quit();
		
		}
}
