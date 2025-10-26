package com.Webtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A2_Amazontest {
	public WebDriver driver;
	@Parameters({"bname"})
  @Test
  public void open_amazon(String bname) {
	  
	  if(bname.equals("Chrome")) {
		  driver =new ChromeDriver();
		  System.out.println("Session started in Chrome");
	  }else if(bname.equals("Firefox")){
		  driver = new FirefoxDriver();
		  System.out.println("Session started in FireFox");
	  }else if(bname.equals("Edge")){
		  driver = new EdgeDriver();
		  System.out.println("Session started in Edge");
	  }
	  
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.in");
	  
	  String title = driver.getTitle();
	  System.out.println("Page title for "+bname+" is: "+title);
	  Assert.assertTrue(title.contains("Amazon"), "Title does not contain Amazon");
	  System.out.println("Title matched");
  }

	
	
}
