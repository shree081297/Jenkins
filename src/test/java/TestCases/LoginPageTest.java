package TestCases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginPageTest extends BaseClass{

	@Test
	public void TC_001() {
		LoginPage lp=new LoginPage();
		String username=sheet.getRow(1).getCell(0).getStringCellValue();
		System.out.println(username);
		String password=sheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(password);
		lp.EnterLoginCreds(username, password);
		lp.validateTitle("Swag Labs");
	//	lp.validateLogo();
		lp.VerifyingProduct("Products");
		
	}
	@Test
	public void TC_002() throws InterruptedException {
		LoginPage lp=new LoginPage();
		String username1=sheet.getRow(2).getCell(0).getStringCellValue();
		System.out.println(username1);
		String password1=sheet.getRow(2).getCell(1).getStringCellValue();
		System.out.println(password1);
		lp.EnterLoginCreds(username1, password1);
		lp.VerifyingLoggedUser("Epic sadface: Sorry, this user has been locked out.");
	}
	
	@Test
	public void TC_003() {
		LoginPage lp=new LoginPage();
		String username2=sheet.getRow(3).getCell(0).getStringCellValue();
		System.out.println(username2);
		String password2=sheet.getRow(3).getCell(1).getStringCellValue();
		System.out.println(password2);
		lp.EnterLoginCreds(username2, password2);
		lp.VerifyingLoggedUser("Epic sadface: Username and password do not match any user in this service");
	}
	Map<String, String> testdata = new HashMap<String, String>();

	@Test(dataProvider = "dp")
	public void TC04_LoginSuccessTest(String key) {

		LoginPage lp = new LoginPage();
		lp.EnterLoginCreds(key, testdata.get(key));
	}

	@DataProvider(name = "dp")
	public Iterator<String> method1() {

		testdata.put("aaa@xyz.com", "Abc@1234");
		testdata.put("bbb@xyz.com", "Abc@1234");
		testdata.put("ccc@xyz.com", "Abc@1234");
		testdata.put("Srikanthkurella123@gmail.com", "Shree@123");

		return testdata.keySet().iterator();

	}

}
