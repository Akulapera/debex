package ru.wildberries;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParserPrice
{
    private List<WebElement> elements;
    private List<Integer> prices;
    private List<Integer> prices_sorted;


    public ParserPrice(List<WebElement> elements)
    {
        this.elements = elements;
        this.prices = new ArrayList<Integer>();
        this.prices_sorted = new ArrayList<Integer>();
    }

    public List<Integer> get_prices_sorted() {
        return prices_sorted;
    }

    public List<Integer> get_prices() {
        return this.prices;
    }

    public void parse()
    {
//        List<Integer> prices = new ArrayList<>();
        for (WebElement element:this.elements) {
            //System.out.println(element.getText());
            List<String> result = Splitter.on(" ").trimResults().splitToList(element.getText());
            System.out.println(result);
            String price = Joiner.on("").join(result.get(0), result.get(1));
            System.out.println(price);
            Integer price_int = Integer.parseInt(price);
            prices.add(price_int);
        }
    }
    public void sort()
    {
        this.prices_sorted = new ArrayList<>(this.prices);
        Collections.sort(this.prices_sorted);
    }
}
