package com.cases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.chrome.handler.ChromedriverHandler;

public class Case1 {
	
	private static AndroidDriver driver; 
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName","Android");
		capabilities.setCapability("platformVersion", "4.4");
		//capabilities.setCapability("platformName","Android");
		capabilities.setCapability("appPackage", "com.ionicframework.tax135288");
		capabilities.setCapability("appActivity", ".MainActivity");
		try {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebElement view0 = driver.findElementByClassName("android.webkit.WebView");
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			  System.out.println("contextName: " + contextName);
			  if (contextName.contains("WEBVIEW_com.ionicframework.tax135288")) {
			    driver.context(contextName);
			  }
			}
		
		List<WebElement> list = driver.findElementsByClassName("row");
		
		System.out.println("list: " + list.size());
		WebElement webElement0 = list.get(0);
		
		//进入“电子发票”
		//driver.findElement(By.xpath("html/body/ion-nav-view/ion-tabs/ion-nav-view/ion-view/ion-content/div[1]/div[2]/div[2]")).click();
		
		//进入“应用商城”
		driver.findElementByXPath("html/body/ion-nav-view/ion-tabs/div/a[2]/span").click();
		
		//获得页面源码
		//source = driver.getPageSource();
		//System.out.println("source: " + source);
		
		//进入“分类”
		//driver.findElementByXPath("html/body/ion-nav-view/ion-tabs/ion-nav-view[2]/ion-view/ion-content/div[1]/div[1]/div/div[2]").click();
		
		//driver.pressKeyCode(AndroidKeyCode.BACK);
		
		List<WebElement> list1 = driver.findElementsByClassName("list");
		System.out.println("list1.size(): " + list1.size());
		for(WebElement webElement : list1) {
			System.out.println("text: " + webElement.getText());
		}
		list1.get(0).click();
		
		driver.context("NATIVE_APP");
		int width=driver.manage().window().getSize().width;
        int height=driver.manage().window().getSize().height;  
        driver.swipe(width/2,height*3/4, width/2,height/4, 1000);
        
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.context("WEBVIEW_com.ionicframework.tax135288");
        driver.findElementByXPath("html/body/ion-nav-view/ion-tabs/div/a[2]/span").click();
	}

}


