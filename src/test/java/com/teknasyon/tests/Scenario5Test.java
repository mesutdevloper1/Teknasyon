package com.teknasyon.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Scenario5Test extends BaseTest {

    private AndroidDriver<MobileElement> driver;
    private SwipeUtils swipeUtils;

    @Override
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Driver'ı BaseTest'ten al
        driver = getDriver();  // Bu metodun BaseTest'te mevcut olduğunu varsayıyoruz
        swipeUtils = new SwipeUtils(driver);
    }

    @Test
    public void testNotification() {
        // 'Views' menüsüne tıkla
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
        // Yukarı kaydır
        swipeUtils.swipe(SwipeUtils.Direction.DOWN);
        Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Tabs']")).isDisplayed());

        // 'Notification' menüsüne tıkla
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Notification']")).click();

        // 'Incoming Message' menüsüne tıkla
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='IncomingMessage']")).click();

        // Bildirimi göster
        driver.findElement(By.id("io.appium.android.apis:id/notify_app")).click();

        // Bildirim çubuğunu aç ve bildirimi doğrula
        driver.openNotifications();
        MobileElement notification = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/status_bar_latest_event_content']"));
        Assert.assertTrue(notification.isDisplayed(), "Notification is not displayed!");

        // Bildirime tıkla ve detayı doğrula
        notification.click();
        String detailText = driver.findElement(By.id("io.appium.android.apis:id/message")).getText();
        Assert.assertTrue(detailText.contains("Did you notice that the status bar icon disappeared?"));
    }
}

