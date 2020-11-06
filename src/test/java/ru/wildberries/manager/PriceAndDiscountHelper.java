package ru.wildberries.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PriceAndDiscountHelper extends BaseHelper {

   WebDriver dr;

    public PriceAndDiscountHelper(WebDriver dr) {
        super(dr);
    }

    public void clickPrice(By locator) {
        click(locator);
    }

    public   void clickDiscount(By locator) {
        click(locator);
    }

    public void clickLaptops(By locator) {
        click(locator);
    }

    public void clickElectronica(By locator) {
        click(locator);
    }

    public void clickMenu(By locator) {
        click(locator);
    }

    public void openSite(String url) {
        dr.get(url);
    }
}

