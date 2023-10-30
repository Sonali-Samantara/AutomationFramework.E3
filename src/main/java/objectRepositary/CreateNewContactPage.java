package objectRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{

	//Declaration
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(xpath= "//img[@alt='Select'][1]") //doubt on [1]
	private WebElement OrgLookUpImg;

	@FindBy(name =  "search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name =  "submit")
	private WebElement OrgSearchButton;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory .initElements( driver , this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getOrgLookUoImg() {
		return OrgLookUpImg;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getOrgSearchButton() {
		return OrgSearchButton;
	}
	
	//Business Library
	
	/**
	 * This method will create contact with mandatory fields and save
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveButton.click();
	}
	
	/**
	 * This method will create contact with organization
	 * @param driver
	 * @param LASTNAME
	 * @param ORGNAME
	 */
	public void createNewContact(WebDriver driver , String LASTNAME , String ORGNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrgLookUpImg.click();
		switchToWindow(driver, "Accounts" );
		OrgSearchEdt.sendKeys(ORGNAME);
		OrgSearchButton.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver , "Contacts");
		SaveButton.click();
		
	}
	
	
	

		    
			
			
	
	
	
	
	
	
	
	
	
	
	
	
	
}
