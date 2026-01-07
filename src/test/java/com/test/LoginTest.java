package com.test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest {

    AndroidDriver driver;

    @BeforeMethod
    public void setup() throws Exception {

    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setCapability("platformName", "Android");
    	caps.setCapability("appium:deviceName", "narzo 50A");
    	caps.setCapability("appium:udid", "192.168.0.123:5555");
    	caps.setCapability("appium:automationName", "UiAutomator2");
    	caps.setCapability("appium:appPackage", "com.ihmmobileapp");
    	caps.setCapability("appium:appActivity", "com.ihmmobileapp.MainActivity");
    	caps.setCapability("newCommandTimeout", 300);
    	caps.setCapability("adbExecTimeout", 60000);
    	caps.setCapability("uiautomator2ServerInstallTimeout", 60000);
    	caps.setCapability("androidInstallTimeout", 120000);


    	driver = new AndroidDriver(
    	    new URL("http://127.0.0.1:4723/wd/hub"),
    	    caps
    	);

    }

    @Test
    public void validLoginTest() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("admin123");
        driver.findElement(By.id("login")).click();
    }
}
