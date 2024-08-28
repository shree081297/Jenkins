package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestCases.BaseClass;

public class CheckOutPage extends BaseClass {

	@FindBy(id = "first-name")
	WebElement firstname;

	@FindBy(id = "last-name")
	WebElement lastname;

	@FindBy(id = "postal-code")
	WebElement zip;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement continueBtn;

	public CheckOutPage() {
		PageFactory.initElements(driver, this);
	}

	public void EnterData(String fn, String ln,String zp) {
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		zip.sendKeys(zp);
		continueBtn.click();
	}

}
