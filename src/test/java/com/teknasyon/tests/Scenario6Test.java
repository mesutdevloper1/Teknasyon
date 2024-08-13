package com.teknasyon.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Scenario6Test extends BaseTest {

    @Override
    public void setUp() throws MalformedURLException {
        // Delete and reinstall app
        driver.removeApp("com.example.myapp");
        super.setUp();
    }


    @Test
    public void testScrollableTabs() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@text='Tabs']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='5. Scrollable']")).click();

        // Scroll to last tab
        driver.findElement(By.xpath("//android.widget.TextView[@text='Tab 30']")).click();

        // Verify page content
        String pageText = driver.findElement(By.id("com.example.myapp:id/page_content")).getText();
        Assert.assertTrue(pageText.contains("Tab 30 Content"));
    }
}
