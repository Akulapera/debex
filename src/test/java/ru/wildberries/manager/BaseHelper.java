package ru.wildberries.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class BaseHelper {
    WebDriver dr;

    public BaseHelper(WebDriver dr) {
        this.dr = dr;
    }

    public void maximizeWindow() {
        dr.manage().window().maximize();
    }

    public List<WebElement> getWebElements(By locator) {
        return dr.findElements(locator);
    }

    public void pause(int sec) throws InterruptedException {
        Thread.sleep(sec);

    }
    public void click(By locator) {
        dr.findElement(locator).click();
    }
}
