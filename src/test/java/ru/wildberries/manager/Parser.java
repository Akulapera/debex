package ru.wildberries.manager;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parser
{
    private List<WebElement> elements;
    private List<Integer> prices;
    private List<Integer> prices_sorted;
    private List<Integer> discounts;
    private List<Integer> discounts_sorted;


    public Parser(List<WebElement> elements)
    {
        this.elements = elements;
        this.prices = new ArrayList<Integer>();
        this.prices_sorted = new ArrayList<Integer>();
        this.discounts = new ArrayList<Integer>();
        this.discounts_sorted = new ArrayList<Integer>();
    }

    public List<Integer> get_prices_sorted() {
        return this.prices_sorted;
    }

    public List<Integer> get_prices() {
        return this.prices;
    }

    public void parse_prices()
    {
        for (WebElement element:this.elements) {
            //System.out.println(element.getText());
            List<String> result = Splitter.on(" ").trimResults().splitToList(element.getText());
           // System.out.println(result);
            String price = Joiner.on("").join(result.get(0), result.get(1));
            //System.out.println(price);
            Integer price_int = Integer.parseInt(price);
            prices.add(price_int);
        }
    }
    public void sort_prices()
    {
        this.prices_sorted = new ArrayList<>(this.prices);
        Collections.sort(this.prices_sorted);
    }
    public void parse_discounts()
    {
        for (WebElement element:this.elements) {
            //System.out.println(element.getText());
            // -30%
            List<String> res = Splitter.on("%").trimResults().splitToList(element.getText());
            Integer price_int = Integer.parseInt(res.get(0));
            this.discounts.add(price_int);
        }
    }
    public void sort_discounts()
    {
        this.discounts_sorted = new ArrayList<>(this.discounts);
        Collections.sort(this.discounts_sorted);
    }
    public List<Integer> getDiscounts_sorted() {
        return this.discounts_sorted;
    }

    public List<Integer> getDiscounts() {
        return this.discounts;
    }
}
