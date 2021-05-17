package com.brein.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import atu.testrecorder.ATUTestRecorder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginTest {

	  private WebDriver driver;
	  private ATUTestRecorder recorder;
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
	  
		@BeforeTest
	public void beforeTest() throws Exception{
			 DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
	  Date date = new Date();		  
	  recorder = new ATUTestRecorder(System.getProperty("user.dir")+"/videos",dateFormat.format(date),false);		 
		  recorder.start();	
	}
	
	@AfterTest
	public void afterTest() throws Exception{
		recorder.stop();
	}
	
	@BeforeSuite
	public synchronized void beforeSuite() throws Exception{
		deletevideos(System.getProperty("user.dir")+"/videos");
	}
	public static void deletevideos(String path) {
		File directory = new File(path);
		File[] files = directory.listFiles();
		for (File file: files) {
			file.delete();
		}
	}

}
