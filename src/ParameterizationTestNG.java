import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParameterizationTestNG extends TestBase{
	public WebDriver driver;

	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Srinivas goud\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.crmpro.com/");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = ReadExcelData.readData("NewData");
		return data;
	}

	@Test(dataProvider = "getData")
	/*public void loginTest(Hashtable<String, String> table) throws InterruptedException {
		WebElement uname = driver.findElement(By.name("username"));
		uname.sendKeys(table.get("userName"));
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys(table.get("password"));
		Thread.sleep(3000);
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		loginBtn.click();*/
	public void loginTest(String userName, String password) throws InterruptedException {
		WebElement uname = driver.findElement(By.name("username"));
		uname.sendKeys(userName);
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys(password);
		Thread.sleep(3000);
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		loginBtn.click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}