package com.clientbase.frontend;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.clientbase.dao.EmployeeRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class CorrectUpdateTest  extends AbstractTestNGSpringContextTests  {
	
	@Autowired EmployeeRepository empRep;
	private WebDriver driver;
	JavascriptExecutor js;
	@Value("com.package.firefoxpath") String FfPath;
 
	
	@Test
	public void correctUpdate() {
		
		System.setProperty("webdriver.gecko.driver", FfPath);
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		
		var id = empRep.findByFullname("Макс Фрай").get(0).getEmployeeId();
		
		driver.get("http://localhost:8080/");
	    driver.manage().window().setSize(new Dimension(718, 692));
	    driver.findElement(By.linkText("Сотрудники")).click();
	    driver.findElement(By.name("searchString")).click();
	    driver.findElement(By.name("searchString")).sendKeys("макс");
	    driver.findElement(By.cssSelector("button")).click();
	    driver.findElement(By.linkText("Макс Фрай")).click();
	    driver.findElement(By.name("first_name")).click();
	    driver.findElement(By.name("first_name")).sendKeys(Keys.CONTROL + "a");
	    driver.findElement(By.name("first_name")).sendKeys(Keys.DELETE);
	    driver.findElement(By.name("first_name")).sendKeys("Максик");
	    driver.findElement(By.name("passport_date")).click();
	    driver.findElement(By.name("passport_date")).sendKeys(Keys.CONTROL + "a");
	    driver.findElement(By.name("passport_date")).sendKeys(Keys.DELETE);
	    driver.findElement(By.name("passport_date")).sendKeys("11.08.2000");
	    driver.findElement(By.cssSelector("form")).click();
	    driver.findElement(By.name("edit")).click();
	    
	    assertTrue("name changed", empRep.findById(id).get().getFirstName().equals("Максик"));
	    
		driver.quit();
  }
}
