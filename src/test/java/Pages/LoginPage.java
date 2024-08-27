package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestCases.BaseClass;

public class LoginPage extends BaseClass{

	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='login_logo']")
	WebElement logo;
	
	@FindBy(xpath="//div[text()='Products']")
	WebElement product;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement LogoutUserMessage, ErrorMessage;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public void EnterLoginCreds(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	public void validateTitle(String ExpectedTitle) {
		String ActualTitle=driver.getTitle();
		if(ActualTitle.equals(ExpectedTitle)) {
			System.out.println("Title matched");
		}else {
			System.out.println("title mismatch");
		}
	}
	public void validateLogo() {
		Assert.assertTrue(logo.isDisplayed());
	}
	public void VerifyingProduct(String ExpectedResult) {
		String ActualTitle=product.getText();
		Assert.assertEquals(ActualTitle, ExpectedResult);
	}
	public void VerifyingLoggedUser(String ExpectedLoggedUser) {
		String ActualTitle1=LogoutUserMessage.getText();
		Assert.assertEquals(ActualTitle1,ExpectedLoggedUser);
	}
	public void VerifyingErrorMessage(String ExpectedErrorMessage) {
		String ActualErrorMess=ErrorMessage.getText();
		Assert.assertEquals(ActualErrorMess, ExpectedErrorMessage);
		
	}
}
