package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility {

	//Declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement SaveButton;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	//utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	

	//Business Libraries
	
	/**
	 * This Method will create new organization with mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveButton.click();
	}
	
	/**
	 * This method will create new organization with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME , String INDUSTRY)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown, INDUSTRY );
	}
	
	/**
	 * This method will create new organization with industry and type drop down 
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createNewOrganization(String ORGNAME , String INDUSTRY , String TYPE)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(IndustryDropDown, INDUSTRY );
		handleDropDown(typeDropDown , TYPE);
		SaveButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
