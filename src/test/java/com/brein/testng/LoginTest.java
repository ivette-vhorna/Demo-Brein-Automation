package com.brein.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
 

public class LoginTest {

	  private WebDriver driver;
	 
	  LoginPage loginPage;
	
	  
	  @Test
	  public void test() throws InterruptedException {
		  loginPage.iniciar_sesion();
		  Thread.sleep(3000);
	  }
	  @BeforeClass
	  public void beforeClass() {
		  loginPage = new LoginPage(driver);
		  driver = loginPage.chromeDriverConnection("W");
	      loginPage.visit("https://frida-clientes-development.web.app/");
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }
	  


}
