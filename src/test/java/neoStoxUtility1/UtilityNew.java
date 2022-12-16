package neoStoxUtility1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityNew 
{
	public static String readDataFromPropertyFile(String key) throws IOException 
	{
		//create object of properties class
		Properties prop= new Properties();
		//create object of fileinputstream and pass property file path
		
		FileInputStream myFile= new FileInputStream("neoStoxProp.properties");
		
		prop.load(myFile);
		
		String value = prop.getProperty(key);
		Reporter.log("reading " +key+" from property file..",true);
		return value;
	}
	public static void screenshot(WebDriver driver, String TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("D:\\Velocity\\Java Class\\9th July C\\selenium\\screenshot\\"+TCID+".png");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot..",true);
	}
	
	
	public static void wait(WebDriver driver, int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
		Reporter.log("waiting for "+waitTime+ "ms..",true);
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView()", element);
		Reporter.log("scrolling to element..",true);
	}
	
}
