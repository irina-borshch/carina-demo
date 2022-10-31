package com.qaprosoft.carina.demo.guihw.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.guihw.components.InventoryItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends AbstractPage {

    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageURL("/inventory.html");
    }

    @FindBy(xpath = "//div[@class='inventory_list']")
    public InventoryItem inventory;

    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement cartButton;
    @FindBy(xpath = "//div[@class ='inventory_item_name']")
    private List<ExtendedWebElement> itemButton;
    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement burgerButton;
    @FindBy(id = "logout_sidebar_link")
    private ExtendedWebElement logOutButton;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = "//option[@value='az']")
    private ExtendedWebElement sortAtoZButton;

    @FindBy(xpath = "//option[@value='za']")
    private ExtendedWebElement sortZtoAButton;

    @FindBy(xpath = "//option[@value='lohi']")
    private ExtendedWebElement sortLowToHighButton;

    @FindBy(xpath = "//option[@value='hilo']")
    private ExtendedWebElement sortHighToLowButton;

    public CartPage openCart() {
        this.cartButton.click();
        return new CartPage(driver);
    }

    public InventoryInfoPage choseItem(int chosenItem) {
        this.itemButton.get(chosenItem).click();
        return new InventoryInfoPage(driver);

    }

    public InventoryPage burgerButton(){
        this.burgerButton.click();
        return new InventoryPage(driver);
    }

    public LoginPage logOut(){
        this.logOutButton.click();
        return new LoginPage(driver);
    }

    public void sort(){
        this.sortButton.click();
    }
    public void sortAtoZ(){
        this.sortAtoZButton.click();
    }

    public void sortZtoA(){
        this.sortZtoAButton.click();
    }

    public void sortLowToHigh(){
        this.sortLowToHighButton.click();
    }

    public void sortHighToLow(){
        this.sortHighToLowButton.click();
    }

}

