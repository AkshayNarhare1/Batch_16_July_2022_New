package neoStoxPOMClsses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class NeoSoftPasswordPage
{
	
	@FindBy (id="txt_accesspin") private WebElement passwordField;
	
	@FindBy(id="lnk_submitaccesspin") private WebElement submitButton;

	public NeoSoftPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterPassword(WebDriver driver,String pass)
	{
		UtilityNew.wait(driver, 1000);
		passwordField.sendKeys(pass);
	//	Reporter.log("sending password..",true);
	}
	
	public void clickOnSubMitButton(WebDriver driver)
	{
		UtilityNew.wait(driver, 1000);
		submitButton.click();
	//	Reporter.log("clicking on submit button..",true);
	}
}
