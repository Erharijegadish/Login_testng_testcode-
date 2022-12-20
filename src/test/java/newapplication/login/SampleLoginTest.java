package newapplication.login;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleLoginTest {
	
	WebDriver driver;
	File f1;
	//File f2;
	
	@BeforeClass
	public void browserSetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	
	@Test(priority = 1)
	public void testUsername() {
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("hari03siva@gmail.com");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].setAttribute('style','background: yellow')",username);
		f1 = new File("D:\\data c\\screenshot\\fb1.png");
	}
	
	@Test(priority = 2)
	public void testPassword() {
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("1289ybhdbd");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].setAttribute('style','background: yellow')",password);
		f1 = new File("D:\\data c\\screenshot\\fb2.png");
	}
	
	@AfterMethod
	public void capture() throws IOException {
		TakesScreenshot t = (TakesScreenshot)driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source,f1);
	}
	
	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
}
