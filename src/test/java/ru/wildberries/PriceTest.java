import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.Collections;
import org.testng.Assert;

public class PriceTest extends TestBase  {

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
        List<Integer> prices = new ArrayList<>();

        for (WebElement element:elements) {
            List<String> result = Splitter.on(" ").trimResults().splitToList(element.getText());
            String price = Joiner.on("").join(result.get(0), result.get(1));
            Integer price_int = Integer.parseInt(price);
            prices.add(price_int);
        }
        List sorted = new ArrayList<>(prices);
        Collections.sort(prices);
        Assert.assertEquals(prices, sorted);
    }
//div[@class='j-cataloger-price']/span[@class='price']/span[@class='price-old-block']/span[@class='price-sale active']
}
