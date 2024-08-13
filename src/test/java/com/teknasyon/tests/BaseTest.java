// src/test/java/com/teknasyon/tests/BaseTest.java
package com.teknasyon.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterMethod;



public class BaseTest {
    protected AndroidDriver<MobileElement> driver;


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "c33f53b0");
        caps.setCapability("plaformVersion","12.0");
        caps.setCapability("appPackage", "io.appium.android.apis");
        caps.setCapability("appActivity", ".ApiDemos");
        caps.setCapability("noReset", true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }
    public AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}