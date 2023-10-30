package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.WebDriverUtility;

public class HomePage extends WebDriverUtility  {

	//Declaration--dropdowns,frames,windows,textFields,popups
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(xpath =  "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	
	//Business Library
	/**
	 * This method will click on organizations link
	 */
	
	public void clickOnOrganizationLink()
	{
		organizationLink.click();
	}
	
	/**
	 * This method will on contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsLink.click();
	}
	/**
	 * This method will log out of application
	 * @param driver
	 * @throws InterruptedException
	 */
	
	public void logoutofApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver , administratorImg);
		Thread.sleep(2000);
		signoutLink.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
