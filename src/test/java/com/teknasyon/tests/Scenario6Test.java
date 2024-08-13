package com.teknasyon.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Scenario6Test extends BaseTest {

    @Override
    public void setUp() throws MalformedURLException {
        // Delete and reinstall app
        driver.removeApp("io.appium.android.apis");
        super.setUp();
    }


    @Test
    public void testScrollableTabs() {
        driver.findElement(By.xpath("")).click();

        driver.findElement(By.xpath("")).click();
        driver.findElement(By.xpath("")).click();

        // Scroll to last tab
        driver.findElement(By.xpath("")).click();

        // Verify page content
        String pageText = driver.findElement(By.id("")).getText();
        Assert.assertTrue(pageText.contains("Tab 30 Content"));
    }
}
