package neoStoxBase;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import neoStoxPOMClsses.UtilityNew;

public class BaseNew 
{
	 protected static WebDriver driver;
	
	public  void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Velocity\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(neoStoxUtility1.UtilityNew.readDataFromPropertyFile("devurl"));
		driver.manage().window().maximize();
		UtilityNew.wait(driver, 1000);
		
		Reporter.log("launching browser..",true);
		Reporter.log("launching browser..",true);
		Reporter.log("launching browser..",true);
	}
}
