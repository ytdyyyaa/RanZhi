package com.admin.PageObject;

import static org.testng.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.log.LoggingManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.admin.login.LoginTest;
import com.gargoylesoftware.htmlunit.Page;
import com.webtest.core.BaseTest;

public class AddBokeTest extends BaseTest{
	static Logger log;
	@BeforeMethod
	public void construct(){
		log = LogManager.getLogger(LoginTest.class.getName());
		log.debug("---------------------");
	}
	@AfterMethod
	public void end(){
		log.debug("---------------------");
	}
	@Test
	public void OpenPage(){
		webtest.open("http://localhost:8032/MyMovie/admin.php/Login/index.html");
		log.debug(webtest.getTitle());
	}
//	@Test(dependsOnMethods="OpenPage",dataProvider="LoginMessage",dataProviderClass=DataDriver.class)
//	public void LoginSucessTest(String username,String password) throws InterruptedException{
//		LoginPage LoginPageObj = new LoginPage(webtest);
//		LoginPageObj.userName.sendKeys(username);
//		LoginPageObj.passWord.sendKeys(password);
//		LoginPageObj.btnLogin.click();
//		Thread.sleep(3000);
//		assertTrue(webtest.getHtmlSource().contains("ÍË³ö"));
//		webtest.findElement(By.linkText("ÍË³ö")).click();
//		log.debug("Ò³Ãæ£º"+webtest.getTitle());
//		log.debug("µÇÂ¼³É¹¦");
//	}
//	
//	@Test(dependsOnMethods="OpenPage",dataProvider="LoginMessage",dataProviderClass=DataDriver.class)
//	public void LoginfailTest(String username,String password) throws InterruptedException{
//		LoginPage LoginPageObj = new LoginPage(webtest);
//		LoginPageObj.userName.sendKeys("jij");
//		LoginPageObj.passWord.sendKeys(password);
//		LoginPageObj.btnLogin.click();
//		Thread.sleep(3000);
//		assertTrue(webtest.getHtmlSource().contains("ÕÊºÅ»òÃÜÂë´íÎó£¡"));
//		log.debug("Ò³Ãæ£º"+webtest.getTitle());
//		log.debug("µÇÂ¼Ê§°Ü");
//	}

}
