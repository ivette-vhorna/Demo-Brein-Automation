package com.brein.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.brein.framework.Base;

public class LoginPage extends Base{

	
	By txtemail = By.xpath("//input[@name='email']");
	By txtpasswd = By.xpath("//input[@id='password']");	
	By btningresar = By.xpath("//button[@type='submit']");
	By txtsearch = By.id("product-search");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void iniciar_sesion() {
		wait(10, txtemail);
		type("ggarridom23@gmail.com",txtemail);
		type("frida2021!",txtpasswd);
		click(btningresar);
		wait(10,txtsearch);
		
	}
	
}
