package com.brein.testng;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	private WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	public WebDriver chromeDriverConnection(String so) {
		
		String file="";		
		if (so == "L") {
			file = "Linux/chromedriver";
		}
		if (so == "W") {
			file = "Windows/chromedriver.exe";
		}
		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/drivers/"+file);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;		
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		WebElement type = driver.findElement(locator);
		type.clear();
		type.sendKeys(inputText);		
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	public Boolean idDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public void wait(long timeoutInSeconds, By locator) {
		@Deprecated
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));		
	}
	
	  
}
