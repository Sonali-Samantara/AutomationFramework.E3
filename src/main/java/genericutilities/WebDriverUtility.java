package genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consists of all generic methods related to web driver actions
 * @author s.sama
 */
public class WebDriverUtility { //what we write here is entire basic selenium

	/**
	 * this method will maximize the window
	 * 
	 * @param driver
	 */
	/////WebDriver driver= null; //(option-1)if it is declared as globally then all the driver created will be null..so better avoid this method
	public void maximizeWindow(WebDriver driver) //option-2 parameterised constructor  
	{ 
		driver.manage().window().maximize(); //browser launched and maximize
	}
	
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) ///we give driver as argument so that each time we get updated.....when we call it
	{
		driver.manage().window().minimize(); //browser launched and maximize	
	}
	
	/**
	 * this method will wait for the page to download
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * this method will wait foe particular element to be visible in the DOM i.e Document Object Module 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method will wait for a particular to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//////SELECT class///////
	
	/**
	 * this method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element , int index) //select class will operate on elements
	{
		Select sel= new Select(element);
	    sel.selectByIndex(index);
	}
	
	/**
	 * this method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element , String value) //method overloading is done here with same name(handleDropDown) bcoz functionality is same but the way they achive is different...so to avoid confusions
	{
		Select sel= new Select(element);
	    sel.selectByValue(value);
	}
	
	/**
	 * this method will handle dropdown by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text , WebElement element)
	{
		Select sel= new Select(element);
	    sel.selectByVisibleText(text);
	}
	
	
	//////ACTIONS class///////in actions class not all,,,but methods can be overloaded
	
	/**
	 * this method will perform mouse hovering actions
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver , WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * this method will move the cursor based on offset and click on webpage
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.moveByOffset(10,10).click().perform();
	}
	
	/**
	 * this method will perform right click actions
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions action= new Actions(driver);
		action.contextClick().perform();
	}
	
	/**
	 * this will perform double click actions
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * this method will perform drag and drop actions
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropActions(WebDriver driver , WebElement srcEle , WebElement dstEle)
	{
		Actions action= new Actions(driver);
		action.dragAndDrop(srcEle, dstEle).perform();
	}
	
	/**
	 * this method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver , int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * this method will handle frame by name or ID
	 * @param driver
	 * @param NameOrID
	 */
	public void switchToFrame(WebDriver driver , String NameOrID)
	{
		driver.switchTo().frame(NameOrID);
	}
	
	/**
	 * this method will handle frame by web Element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver , WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * this method will scroll up by 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver) 
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);"," ");
	}
	
	/**
	 * this method will scroll down by 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver) 
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);"," ");
	}
	
	//////*******ALERT PopUp*******/////
	/**
	 * this method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * this method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;
	}
	
	/**
	 * this method will fetch the alert text and return it to caller
	 * @param driver
	 * @return 
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}

	
	/////***********Take ScreenShot*******/////////
	
	/**
	 * this method will take screenshot and return the dst path
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver , String screenshotName ) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver; //driver is casted..on right side write driver and cast it
		File src = ts.getScreenshotAs(OutputType.FILE); //this is a temporary location
	    File dst = new File(".\\Screenshots\\"+screenshotName+".png"); //permanent location
	                             //Scenario1.png
	    Files.copy(src, dst);
	    
	    return dst.getAbsolutePath(); //used for extent reports
	    
	}
	
	/**
	 * This method will switch from one window to another based on window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver , String partialWinTitle)
	{
		//step-1: get all the window IDs
	 Set<String> allWinIds = driver.getWindowHandles();
		
		//step-2: navigate through each window
	for(String winID:allWinIds)
	{
		//step-3: switch to each window and capture the title
		String actTitle = driver.switchTo().window(winID).getTitle();
		
		//step-4: compare act title with expected partial title
		if (actTitle.contains(partialWinTitle)) 
		{
			break;
		}
	}
	
 }
	
	
}
