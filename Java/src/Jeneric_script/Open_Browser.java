package Jeneric_script;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Open_Browser implements Constant_Data{
	public WebDriver driver;
	@BeforeMethod
	public void open()
	{
		System.setProperty(chrome_key,chrome_value);
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//here Timeunit is the enum javaconcept
		driver.manage().window().maximize();
		driver.get(url);
	}
	@AfterMethod()
	public void close(ITestResult res) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}
