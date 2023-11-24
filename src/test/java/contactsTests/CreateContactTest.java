package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutilities.BaseClass;
import objectRepositary.ContactInfoPage;
import objectRepositary.ContactsPage;
import objectRepositary.CreateNewContactPage;
import objectRepositary.HomePage;

@Listeners(genericutilities.ListenersImplementationClass.class)
public class CreateContactTest extends BaseClass {


	@Test(groups={"SmokeSuite","RegressionSuite"})
	public void createContact() throws EncryptedDocumentException, IOException
	{
		String LASTNAME = eUtil.readDataFromExcel("contacts", 1, 2);

				
	  //Step 10:click on contacts link
	   HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("clicked on contacts link");
		
		//Step 11:Click On create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnCreateContactPageImg();
		//Assert.fail();
		Reporter.log("clicked on create contact look up image");
		
		//Step 12: create contact with Organization
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("contact created successfully");
		
		//Step 13: Validation
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getHeaderText();
		Reporter.log("header captured");
		
		//Assert.fail();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		Reporter.log("Header validated");
		
		System.out.println(contactHeader);

	}
	
	@Test
	public void demo()
	{
		System.out.println("demo");
		System.out.println("Doing poll SCM");
	}
	


}
