package com.actions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestAsyncKeyboardActions {
	@Test
	public void testkeyboardActions() throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement search=driver.findElement(By.id("myInput"));
		Actions act1=new Actions(driver);
		act1.sendKeys(search,"b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").perform();
		act1.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"))).click().build().perform();
		driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
		String text=driver.findElement(By.xpath("//h4[contains(text(),'Hand bag')]")).getText();
		Assert.assertTrue(text.contains("Hand bag"));
	}
}








