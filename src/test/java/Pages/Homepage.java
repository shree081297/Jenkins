package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestCases.BaseClass;

public class Homepage extends BaseClass{

	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	WebElement SauceLabsBackpack;
	
	@FindBy(xpath="//div[@class='inventory_details_price']")
	WebElement price;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	WebElement AddToCart;
	
	@FindBy(id="shopping_cart_container")
	WebElement MiniCart;
	

	@FindBy(xpath="//div[@class='app_logo']")
	WebElement CartLogo;
	
	@FindBy(xpath="//a[text()='CHECKOUT']")
	WebElement checkout;
	
	
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	public void clickOnProduct() {
		SauceLabsBackpack.click();
	}
	public void validatePrice(String ExpectedPrice) {
		String ActualPrice=price.getText();
		Assert.assertEquals(ActualPrice, ExpectedPrice);
	}
	public void clickAddToCart() {
		AddToCart.click();
	}
	public void clickMiniCart() {
		MiniCart.click();
	}
	public void validateCartLogo() {
		Assert.assertTrue(CartLogo.isDisplayed());
	}
	public void Checkout() {
		checkout.click();
	}
	
	
}
