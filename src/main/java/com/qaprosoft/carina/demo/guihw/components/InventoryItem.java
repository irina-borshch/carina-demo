package com.qaprosoft.carina.demo.guihw.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryItem extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    public List<ExtendedWebElement> inventoryNames;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<ExtendedWebElement> inventoryPrice;


    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    public List<ExtendedWebElement> addButton;

    public InventoryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
