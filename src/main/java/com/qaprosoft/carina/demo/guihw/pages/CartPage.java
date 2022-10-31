package com.qaprosoft.carina.demo.guihw.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.guihw.components.CartItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    public CartPage(WebDriver driver) {
        super(driver);
        setPageURL("/cart.html");
    }

    @FindBy(xpath = "//div[@class='cart_list']")
    public CartItem cart;
}
