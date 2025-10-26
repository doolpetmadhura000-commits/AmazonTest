package com.Webtests;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A2_Amazontest {
	public WebDriver driver;
	public URI uri = URI.create("http://localhost:4444/wd/hub");
	@SuppressWarnings("deprecation")
	@Parameters({"bname"})
  @Test
  public void open_amazon(String bname) throws MalformedURLException {
	  
	  if(bname.equals("Chrome")) {
		  ChromeOptions option = new ChromeOptions();
		  driver =new RemoteWebDriver(uri.toURL(), option);
		  System.out.println("Session started in Chrome");
	  }else if(bname.equals("Firefox")){
		  FirefoxOptions option = new FirefoxOptions();
		  driver =new RemoteWebDriver(uri.toURL(),option);
		  System.out.println("Session started in FireFox");
	  }else if(bname.equals("Edge")){
		  EdgeOptions option = new EdgeOptions();
		  driver =new RemoteWebDriver(uri.toURL(),option);
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
