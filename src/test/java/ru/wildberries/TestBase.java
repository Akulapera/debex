package ru.wildberries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver dr;

    @BeforeMethod
    public void setUp(){
    dr=new ChromeDriver();
    dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
   public  void tearDown(){
   dr.quit();
    }

    protected void clickPrice(By locator) {
        dr.findElement(locator).click();
    }
    protected  void clickDiscount(By locator) {
        dr.findElement(locator).click();
    }
    protected void clickLaptops(By locator) {
        clickPrice(locator);
    }
    protected void clickElectronica(By locator) {
        clickLaptops(locator);
    }
    protected void clickMenu(By locator) {
        clickLaptops(locator);
    }

    protected void maximizeWindow() {
        dr.manage().window().maximize();
    }

    protected void openSite(String url) {
        dr.get(url);
    }

    protected List<WebElement> getWebElements(By locator) {
        return dr.findElements(locator);
    }
    protected void pause(int sec) throws InterruptedException {
        Thread.sleep(sec);
    }
}
