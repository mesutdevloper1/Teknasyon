package com.teknasyon.tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

public class Scenario6Test extends BaseTest {

    private AndroidDriver driver;
    private SwipeUtils swipeUtils;

    @Override
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Uygulamayı kaldır ve yeniden yükle
        driver.removeApp("io.appium.android.apis");
        super.setUp();
        swipeUtils = new SwipeUtils(driver);
    }

    @Test
    public void testScrollableTabs() {
        // 'Views' menüsüne tıkla
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();

        // Ekranı yukarı kaydır
        swipeUtils.swipe(SwipeUtils.Direction.UP);

        // 'Tabs' menüsünün varlığını doğrula ve tıkla
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Tabs']")).isDisplayed();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Tabs']")).click();

        // '5. Scrollable' menüsüne tıkla
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='5. Scrollable']")).click();

        // Son sekmeye kaydır ve tıkla
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='TAB 30']")).click();

        // Sayfa içeriğini doğrula
        String pageText = driver.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Tab 30 Content')]")).getText();
        Assert.assertTrue(pageText.contains("Tab 30 Content"));
    }
}

