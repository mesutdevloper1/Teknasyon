package com.teknasyon.tests;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Scenario4Test extends BaseTest {

    @Test
    public void testHideAndShow() {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();

        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Fragment']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Hide and Show']")).click();

        // Verify initial state
        MobileElement hideButton = driver.findElement(By.id("io.appium.android.apis:id/frag1hide"));
        MobileElement hideButton2 = driver.findElement(By.id("io.appium.android.apis:id/frag2hide"));

        MobileElement textBox = driver.findElement(By.xpath("(//android.widget.EditText[@content-desc='Initial text.'])[1]"));
        MobileElement textBox2 = driver.findElement(By.id("(//android.widget.EditText[@content-desc='Initial text.'])[2]"));


        Assert.assertTrue(hideButton.isDisplayed());
        Assert.assertTrue(textBox.isDisplayed());

        // Click Hide and verify
        hideButton.click();
        Assert.assertFalse(textBox.isDisplayed());
        Assert.assertEquals(hideButton.getText(), "SHOW");

        // Click Show and verify
        hideButton.click();
        Assert.assertTrue(textBox.isDisplayed());
        Assert.assertEquals(hideButton.getText(), "Hide");


        hideButton.click();
        Assert.assertFalse(textBox2.isDisplayed());
        Assert.assertEquals(hideButton2.getText(), "SHOW");

        // Click Show and verify
        hideButton.click();
        Assert.assertTrue(textBox2.isDisplayed());
        Assert.assertEquals(hideButton2.getText(), "Hide");
    }
}
