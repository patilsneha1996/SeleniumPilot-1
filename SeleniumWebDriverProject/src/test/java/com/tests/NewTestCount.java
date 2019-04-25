package com.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.util.DriverUtility;

public class NewTestCount {
	@Test
	public void testTagCount()
	{
		WebDriver driver=DriverUtility.getDriver("chrome");
		driver.get("http://www.google.co.in/");
		driver.manage().window().maximize();
		WebElement div=driver.findElement(By.id("SIvCob"));
		List<WebElement>list=div.findElements(By.tagName("a"));
		Assert.assertEquals(list.size(),9);
	}

}
