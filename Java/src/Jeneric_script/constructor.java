package Jeneric_script;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class constructor {
	public constructor(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
