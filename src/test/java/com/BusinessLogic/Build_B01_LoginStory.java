package com.BusinessLogic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Generic_Utils.ExcelUtils;
import com.Generic_Utils.IframeConstant;
import com.PomPages.Pom_loginPage;


public class Build_B01_LoginStory 
{

	@Test
	public void login_test() throws InterruptedException, IOException
	{
		WebDriver driver=new ChromeDriver();
		ExcelUtils xlutils=new ExcelUtils();
		String usn = xlutils.getCellData("sheet1", 1, 0);
		String psw = xlutils.getCellData("sheet1", 1, 1);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		
		Pom_loginPage pl=new Pom_loginPage(driver);
		
		int rowCount = xlutils.getRowCount("sheet1");
		System.out.println("This is the total number of rows : "+ rowCount);//2
		
		int cellCount = xlutils.getCellCount("sheet1",0);
		System.out.println("This is the total number of column : "+ cellCount);//2
		
		pl.loginToApp(usn,psw);
		Thread.sleep(8000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		pl.loginToApp(xlutils.getCellData("sheet1", 1, 0), xlutils.getCellData("sheet1", 1, 1));
		Thread.sleep(3000);
		pl.getLogin_btn().click();
		Thread.sleep(3000);
		WebElement verify = 
		driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		String text = verify.getText();
		System.out.println(text+"===> Home Page is Displayed");
		Thread.sleep(3000);
		
		
		driver.quit();
		
	}
}


   // Prepared by instagram id : Hemsqalearnings