package com.teknasyon.tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

public class SwipeUtils {

    private AndroidDriver driver;

    public SwipeUtils(AndroidDriver driver) {
        this.driver = driver;
    }

    public void swipe(Direction direction) {
        Dimension size = driver.manage().window().getSize();
        int startX = 0;
        int endX = 0;
        int startY = 0;
        int endY = 0;

        switch (direction) {
            case UP:
                startX = size.width / 2;
                startY = (int) (size.height * 0.8);
                endY = (int) (size.height * 0.2);
                break;
            case DOWN:
                startX = size.width / 2;
                startY = (int) (size.height * 0.2);
                endY = (int) (size.height * 0.8);
                break;
            case LEFT:
                startY = size.height / 2;
                startX = (int) (size.width * 0.8);
                endX = (int) (size.width * 0.2);
                break;
            case RIGHT:
                startY = size.height / 2;
                startX = (int) (size.width * 0.2);
                endX = (int) (size.width * 0.8);
                break;
        }

        new TouchAction(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }
}