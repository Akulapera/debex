package ru.wildberries.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.testng.Assert;
import ru.wildberries.manager.Parser;

public class PriceTest extends TestBase {

    @Test
    public  void sortingPriceTest() throws Exception{
        app.getPriceAndDiscountHelper().maximizeWindow();
        app.getPriceAndDiscountHelper().pause(3000);
        app.getPriceAndDiscountHelper().clickMenu(By.cssSelector("[type=button]"));
        app.getPriceAndDiscountHelper().clickElectronica(By.cssSelector("[href=\"/catalog/elektronika\"]"));
        app.getPriceAndDiscountHelper().clickMenu(By.cssSelector("#banner_13d8cd94-ed6b-4b57-92e0-da2b7a282e94"));
        app.getPriceAndDiscountHelper().clickMenu(By.cssSelector("#price"));
        app.getPriceAndDiscountHelper().pause(6000);

        List<WebElement> elements = app.getPriceAndDiscountHelper().getWebElements(By.xpath("//div[@class='j-cataloger-price']/span[@class='price']/ins[@class='lower-price']"));
        Parser price_parser = new Parser(elements);
        price_parser.parse_prices();
        price_parser.sort_prices();

        Assert.assertEquals(price_parser.get_prices(), price_parser.get_prices_sorted());
    }
}
