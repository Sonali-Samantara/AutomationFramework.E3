package objectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	//rule-1
	
	
	//rule-2:
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath="//input[@type='submit']")})
     private WebElement loginButton;	
	
	//rule-3: initialization (initialization of driver)
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}

	//rule-4: Utilisation(using getters)
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	// LoginPage lp=new LoginPage(driver);
	//lp.getUserNameEdt().sendKeys(USERNAME);
	//lp.getPasswordEdt().sendKeys(PASSWORD);
	//lp.getLoginButton().click();
    
	//**** (these above 4 script lines will be written to chk weather i am able to log in to the application or not...write it in (src/test/java) 
	//*** continued..... unde create organization step no-5
	//****screen shot taken ....refer that
	
	
	
	//Business Library - generic methods according to the need of project
	
	/**
	 * this method will log in to the application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME , String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginButton.click();
		
	}
	
	
	//business library is not manadatory
	
}
