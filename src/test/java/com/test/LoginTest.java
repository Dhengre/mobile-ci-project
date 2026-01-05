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
        caps.setCapability("deviceName", "narzo 50A");
        caps.setCapability("udid", "VC55ZPCIAU5TFUQK"); // from adb devices
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("AppPackage", "com.ihmmobileapp");
        caps.setCapability("AppActivity", "com.ihmmobileapp.MainActivity");
        
       
        driver = new AndroidDriver(
            new URL("http://localhost:4723/wd/hub"),
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
