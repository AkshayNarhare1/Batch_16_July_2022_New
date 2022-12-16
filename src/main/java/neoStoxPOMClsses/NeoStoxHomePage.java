package neoStoxPOMClsses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class NeoStoxHomePage 
{
	
	@FindBy (id = "lbl_username") private WebElement userName;
	
	@FindBy(id="lbl_curbalancetop") private WebElement balance;

	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
	
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement popUpCloseBuuton;
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getuserName()
	{
		String actualUserName = userName.getText();
	//	Reporter.log("getting Actual User Name..",true);
		return actualUserName;
		
	}
	
	public String getBalance()
	{
		String actualBalance = balance.getText();
	//	Reporter.log("getting balance..",true);
		return actualBalance;
	}
	
	public void handlePopUp(WebDriver driver)
	{
		UtilityNew.wait(driver, 5000);
		popUpOkButton.click();
		UtilityNew.wait(driver, 500);
		UtilityNew.scrollIntoView(driver, popUpCloseBuuton);
		popUpCloseBuuton.click();
	//	Reporter.log("handeling popup..",true);
	}
	
	public void logOutFromApplication(WebDriver driver)
	{
		userName.click();
		UtilityNew.wait(driver, 500);
		logOutButton.click();
	//	Reporter.log("logging out..",true);
	}
}
