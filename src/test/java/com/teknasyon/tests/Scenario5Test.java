package com.teknasyon.tests;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario5Test extends BaseTest {

    @Test
    public void testNotification() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();


        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Tabs']")).isDisplayed();

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Notification']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='IncomingMessage']")).click();

        // Show notification
        driver.findElement(By.id("io.appium.android.apis:id/notify_app")).click();

        // Open notification bar and verify
        driver.openNotifications();
        MobileElement notification = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout"));
        Assert.assertTrue(notification.isDisplayed());

        // Click notification and verify detail
        notification.click();
        String detailText = driver.findElement(By.id("io.appium.android.apis:id/message")).getText();
        Assert.assertTrue(detailText.contains("Did you notice that the status bar icon disappeared?"));
    }
}
