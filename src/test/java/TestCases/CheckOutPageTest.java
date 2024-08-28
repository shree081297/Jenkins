package TestCases;

import org.testng.annotations.Test;

import Pages.CheckOutPage;
import Pages.Homepage;
import Pages.LoginPage;

public class CheckOutPageTest extends BaseClass {

	@Test
	public void TC_005() {
		LoginPage lp=new LoginPage();
		String username=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(username);
		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(password);
		lp.EnterLoginCreds(username, password);
		
		Homepage hp=new Homepage();
		hp.clickOnProduct();
		hp.validatePrice("$29.99");
		hp.clickAddToCart();
		hp.clickMiniCart();
		hp.validateCartLogo();
		hp.Checkout();
		
		CheckOutPage cop=new CheckOutPage();
	
		String firstname=sheet.getRow(1).getCell(2).getStringCellValue();
		String lastname=sheet.getRow(1).getCell(3).getStringCellValue();
		String zip=sheet.getRow(1).getCell(4).getStringCellValue();
		cop.EnterData(firstname, lastname,zip);
		
	}
}

