package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	// @Parameters("Browser")
	@BeforeMethod
	public void startUp() {
		/*
		 * System.out.println(BrowserName); WebDriver driver=null;
		 * if(BrowserName.contains("chrome")) { driver=new ChromeDriver();
		 * 
		 * }else if(BrowserName.contains("Edge")) { driver=new EdgeDriver(); }else
		 * if(BrowserName.contains("FireFox")) { driver=new FirefoxDriver(); }
		 */
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@BeforeTest
	public void EnterData() throws IOException {
		FileInputStream file = new FileInputStream("excel.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("sheet1");

	}

	@AfterTest
	public void closeExcel() throws IOException {
		workbook.close();
	}
	public void SelectDropDown(WebElement element) {
		Select drop=new Select(element);
		drop.selectByVisibleText(null);
	}
	
}
