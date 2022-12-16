package neoStoxTestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxBase.BaseNew;
import neoStoxPOMClsses.NeoSoftPasswordPage;
import neoStoxPOMClsses.NeoStoxHomePage;
import neoStoxPOMClsses.NeostoxLoginPage;
import neoStoxUtility1.UtilityNew;

@Listeners(neoStoxBase.Listener.class)

public class ValidateNeoStoxUserName extends BaseNew {
  
	NeostoxLoginPage login;
	NeoStoxHomePage home;
	NeoSoftPasswordPage password;
	
	
	@BeforeClass
	public void launchNeoStox() throws IOException
	{
		launchBrowser();
		login= new NeostoxLoginPage(driver);
		password= new NeoSoftPasswordPage(driver);
		home= new NeoStoxHomePage(driver);
	}
	
	@BeforeMethod
	public void signInToNeoStox() throws IOException, InterruptedException
	{
		login.enterMobileNumber(driver, UtilityNew.readDataFromPropertyFile("mobNum"));
		login.clickOnSignInButton(driver);
		Thread.sleep(1000);
		password.enterPassword(driver, UtilityNew.readDataFromPropertyFile("password"));
		Thread.sleep(1000);
		password.clickOnSubMitButton(driver);
		Thread.sleep(1000);
		home.handlePopUp(driver);
	}
	
	@Test
  public void validateUserName() throws IOException
  {
		Assert.assertEquals(home.getuserName(), UtilityNew.readDataFromPropertyFile("expUserName"),"TC Failed, actual and Expected UserNames are not matching");	
  }
	
	@AfterMethod
	public void logOutFromNeostox()
	{
		home.logOutFromApplication(driver);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
}
