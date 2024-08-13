package com.teknasyon.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario1Test extends BaseTest {

    @Test
    public void testCustomTitleTextChange() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Activity']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Custom Title']")).click();

        // Default text check
        String leftText = driver.findElement(By.id("io.appium.android.apis:id/left_text")).getText();
        String rightText = driver.findElement(By.id("io.appium.android.apis:id/right_text")).getText();
        String navLeftBarText = driver.findElement(By.id("io.appium.android.apis:id/left_text_button")).getText();
        String navRightBarText = driver.findElement(By.id("io.appium.android.apis:id/right_text_button")).getText();

        Assert.assertEquals(leftText, "Default Left");
        Assert.assertEquals(rightText, "Default Right");
        Assert.assertEquals(navLeftBarText, "Default Title");
        Assert.assertEquals(navRightBarText, "Default Title");

        // Change text and verify
        driver.findElement(By.id("io.appium.android.apis:id/left_text_edit")).clear();
        driver.findElement(By.id("com.example.myapp:id/left_textbox")).sendKeys("Teknasyon");
        driver.findElement(By.id("io.appium.android.apis:id/right_text_edit")).clear();
        driver.findElement(By.id("io.appium.android.apis:id/right_text_edit")).sendKeys("Mesut");

        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/left_text_button")).getText(), "Teknasyon");
        Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/right_text_button")).getText(), "Mesut");
    }
}
