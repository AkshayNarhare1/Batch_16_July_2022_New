package neoStoxPOMClsses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class NeostoxLoginPage
{
	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber") private WebElement mobileNumField;

	@FindBy(xpath = "//a[@id='lnk_signup1']") private WebElement signIN;
	
	public NeostoxLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(WebDriver driver,String mobNum)
	{
		UtilityNew.wait(driver, 1000);
		mobileNumField.sendKeys(mobNum);
	//	Reporter.log("sending mobile Number..",true);
		
	}
	
	public void clickOnSignInButton(WebDriver driver)
	{
		signIN.click();
		UtilityNew.wait(driver, 1000);
	//	Reporter.log("clicking on signIn button..",true);
	}
}
