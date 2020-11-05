package ru.wildberries;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.testng.Assert;

public class PriceTest extends TestBase {

    @Test
    public  void openChromeTest() throws Exception{

        openSite("https://www.wildberries.ru/");
        maximizeWindow();
        clickMenu(By.cssSelector("[type=button]"));
        clickElectronica(By.cssSelector("[href=\"/catalog/elektronika\"]"));
        clickLaptops(By.cssSelector("#banner_13d8cd94-ed6b-4b57-92e0-da2b7a282e94"));
        clickLaptops(By.cssSelector("#price"));
        Thread.sleep(6000);

        List<WebElement> elements = dr.findElements(By.xpath("//div[@class='j-cataloger-price']/span[@class='price']/ins[@class='lower-price']"));
        ParserPrice price_parser = new ParserPrice(elements);
        price_parser.parse();
        price_parser.sort();
        Assert.assertEquals(price_parser.get_prices(), price_parser.get_prices_sorted());
    }
//div[@class='j-cataloger-price']/span[@class='price']/span[@class='price-old-block']/span[@class='price-sale active']
}
