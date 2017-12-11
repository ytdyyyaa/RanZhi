package com.admin.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "account")
	public WebElement userName;
	@FindBy(name = "password")
	public WebElement passWord;
	@FindBy(xpath = ".//*[@id='submit']")
	public WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
