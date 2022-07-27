package pom_script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Jeneric_script.constructor;

public class POM extends constructor{
	@FindBy(xpath="//input[@id='txtSource']")
	private WebElement from;
	@FindBy(xpath="//li[@class='C120_slist-item C120_suggestion-active']")
	private WebElement from_address;
	@FindBy(xpath="//input[@id='txtDestination']")
	private WebElement To;
	@FindBy(xpath="//li[@class='C120_slist-item C120_suggestion-active']")
	private WebElement To_address;
	@FindBy(xpath="//input[@id='txtOnwardCalendar']")
	private WebElement Date;
	@FindBy(xpath="//button[@class='D120_search_btn searchBuses']")
	private WebElement Search_btn;
	@FindBy(xpath="//span[@class='f-bold busFound']")
	public WebElement bus_count;
	public POM(WebDriver driver)//create constructor
	{
		super(driver);//we can access from outside the class
	}
	public void from(String from1)
	{
		from.sendKeys(from1);
	}
	public void from_address() throws InterruptedException
	{
		from_address.click();
		Thread.sleep(1000);
	}
	public void To(String To1)
	{
		To.sendKeys(To1);
	}
	public void To_address() throws InterruptedException
	{
		To_address.click();
		Thread.sleep(1000);

	}
	public void date(String date1) throws InterruptedException
	{
		Date.sendKeys(date1);
		Thread.sleep(1000);
	}
	public void search_click() throws InterruptedException
	{
		Search_btn.click();
		Thread.sleep(1000);
	}
	public String bus_count()
	{
		return bus_count.getText();

	}

}
