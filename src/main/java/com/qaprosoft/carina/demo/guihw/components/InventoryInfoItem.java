package com.qaprosoft.carina.demo.guihw.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryInfoItem extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    public ExtendedWebElement chosenItemName;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    public ExtendedWebElement chosenItemPrice;

    public InventoryInfoItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

}
