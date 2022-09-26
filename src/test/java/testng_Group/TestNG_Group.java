package testng_Group;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Group {

	
	WebDriver driver=null;
	
	

	@BeforeMethod
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/patel/Webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.saucedemo.com/");

	}

	@Test(groups = "smoke")
	public void login() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/patel/Webdriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
	}

	@Test(groups = "regression")
	public void titleTest() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@Test(groups = {"smoke","regression"})
	public void logoTest() {
		boolean logo = driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
