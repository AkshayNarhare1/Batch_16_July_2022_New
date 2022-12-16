package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxUtility1.UtilityNew;


public class Listener extends BaseNew  implements ITestListener
{
	
	
	public void onTestSuccess(ITestResult result) 
	{
		
		Reporter.log("TC " +result.getName()+" passed successfully",true);	
	}
	
	
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("TC " +result.getName()+" failed",true);
		
		try 
		{
			UtilityNew.screenshot(driver, result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	

}
