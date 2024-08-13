package com.teknasyon.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario2Test extends BaseTest {

    @Test
    public void testListDialogSelection() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
        driver.findElement(By.xpath("/android.widget.TextView[@content-desc='Alert Dialogs']")).click();
        driver.findElement(By.xpath("io.appium.android.apis:id/select_button")).click();

        // Select item from list
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")).click();

        // Verify selected item in alert message
        String alertText = driver.findElement(By.id("android:id/message")).getText();
        Assert.assertTrue(alertText.contains("You selected:"));
    }
}
