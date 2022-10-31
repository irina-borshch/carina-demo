package com.qaprosoft.carina.demo.guihw.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartItem extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<ExtendedWebElement> cartItemNames;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<ExtendedWebElement> cartItemPrices;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
