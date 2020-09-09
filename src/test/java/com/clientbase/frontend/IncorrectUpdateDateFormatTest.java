package com.clientbase.frontend;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.clientbase.ClientBaseApplication;
import com.clientbase.dao.EmployeeRepository;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.util.*;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class IncorrectUpdateDateFormatTest extends AbstractTestNGSpringContextTests{
	
	@Autowired EmployeeRepository empRep;
	private WebDriver driver;
	JavascriptExecutor js;
	@Value("com.package.firefoxpath") String FfPath;
	
	@Test
	public void incorrectUpdateDateFormat() {
		Date d = empRep.findByFullname("Макс Фон").get(0).getPassportDate();
		
		System.setProperty("webdriver.gecko.driver", FfPath);
		driver = new FirefoxDriver();
	    js = (JavascriptExecutor) driver;
	    driver.get("http://127.0.0.1:8080/");
//	    driver.manage().window().setSize(new Dimension(718, 692));
	    driver.findElement(By.linkText("Сотрудники")).click();
	    driver.findElement(By.id("margin-bottom")).click();
	    driver.findElement(By.name("searchString")).click();
	    driver.findElement(By.name("searchString")).sendKeys("макс");
	    driver.findElement(By.cssSelector("button")).click();
	    driver.findElement(By.linkText("Макс фон Штирлиц")).click();
	    driver.findElement(By.name("passport_date")).click();
	    driver.findElement(By.name("passport_date")).sendKeys("1915-01-03");
	    driver.findElement(By.name("passport_date")).sendKeys(Keys.ENTER);
	    
	    assertTrue("date didn't changed", empRep.findByFullname("Макс Фон").get(0).getPassportDate().equals(d));

		driver.quit();
	}
}
