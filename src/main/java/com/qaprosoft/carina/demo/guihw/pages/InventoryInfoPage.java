package com.qaprosoft.carina.demo.guihw.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.guihw.components.InventoryInfoItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryInfoPage extends AbstractPage {

    public InventoryInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='inventory_details_desc_container']")
    public InventoryInfoItem inventoryInfoItem;

    @FindBy(id = "back-to-products")
    private ExtendedWebElement backButton;

    public InventoryPage back() {
        this.backButton.click();
        return new InventoryPage(driver);
    }

}
