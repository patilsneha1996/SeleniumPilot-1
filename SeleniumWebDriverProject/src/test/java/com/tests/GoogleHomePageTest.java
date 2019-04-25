package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.util.DriverUtility;

public class GoogleHomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void beforeMethod()
	{
		driver=DriverUtility.getDriver("chrome");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void afterMethod()
	{
		//driver.close();
	}
	@Test
	public void testDemoWebShop()
	{
		driver.get("http://demowebshop.tricentis.com/");
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("webshop"));
		driver.findElement(By.linkText("Log in")).click();
		WebElement email=driver.findElement(By.id("Email"));
		email.sendKeys("askmail@email.com");
		driver.findElement(By.id("Password")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}
}
