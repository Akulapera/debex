package ru.wildberries.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.wildberries.manager.Parser;

import java.util.List;

public class DiscountTest extends TestBase {
    @Test
    public  void sortingDiscountTest()    throws Exception{
        app.getPriceAndDiscountHelper().maximizeWindow();
        app.getPriceAndDiscountHelper().pause(3000);
        app.getPriceAndDiscountHelper().clickMenu(By.cssSelector("[type=button]"));
        app.getPriceAndDiscountHelper().clickElectronica(By.cssSelector("[href=\"/catalog/elektronika\"]"));
        app.getPriceAndDiscountHelper().clickMenu(By.cssSelector("#banner_13d8cd94-ed6b-4b57-92e0-da2b7a282e94"));
        app.getPriceAndDiscountHelper().clickDiscount(By.cssSelector("#sale"));
        app.getPriceAndDiscountHelper().pause(6000);

        List<WebElement> elements = app.getPriceAndDiscountHelper().getWebElements(By.xpath("//div[@class='j-cataloger-price']/span[@class='price']/span[@class='price-old-block']/span[@class='price-sale active']"));
        Parser discount_parser = new Parser(elements);
        discount_parser.parse_discounts();
        discount_parser.sort_discounts();

        Assert.assertEquals(discount_parser.getDiscounts(), discount_parser.getDiscounts_sorted());
    }
}
