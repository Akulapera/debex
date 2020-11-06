package ru.wildberries.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager  {
    PriceAndDiscountHelper priceAndDiscountHelper;
    WebDriver dr;

    public void init() {
        dr=new ChromeDriver();
        dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        dr.get("https://www.wildberries.ru");
        priceAndDiscountHelper= new PriceAndDiscountHelper(dr);

    }
    public void stop() {
        dr.quit();
    }

    public PriceAndDiscountHelper getPriceAndDiscountHelper() {
        return priceAndDiscountHelper;
    }
}
