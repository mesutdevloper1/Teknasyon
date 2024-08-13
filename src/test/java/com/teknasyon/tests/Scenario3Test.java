package com.teknasyon.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.testng.annotations.Test;


public class Scenario3Test extends BaseTest {

    TouchAction action = new TouchAction(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);


    @Test
    public void testContextMenu() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Fragment']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Context Menu']")).click();


        // Long press on button
        MobileElement longPressBtn = driver.findElement(By.id("io.appium.android.apis:id/long_press"));
       // longPressBtn.click(); // Long press for 2 seconds


        action.longPress(ElementOption.element(longPressBtn))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))) // 3 saniye boyunca basılı tut
                .release()
                .perform();

        // Verify menu items
        Assert.assertTrue(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")).isDisplayed());
    }
}
