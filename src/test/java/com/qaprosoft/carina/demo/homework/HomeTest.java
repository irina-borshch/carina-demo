package com.qaprosoft.carina.demo.homework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.guihw.pages.CartPage;
import com.qaprosoft.carina.demo.guihw.pages.InventoryInfoPage;
import com.qaprosoft.carina.demo.guihw.pages.InventoryPage;
import com.qaprosoft.carina.demo.guihw.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


public class HomeTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "Iryna")
    public void testBadLogIn() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.logIn("", "");
        String expectedUrl = "https://www.saucedemo.com";
        Assert.assertTrue(loginPage.getCurrentUrl().contains(expectedUrl));
        Assert.assertTrue(loginPage.getPageSource().contains("Epic sadface: Username is required"));
    }

    @Test
    @MethodOwner(owner = "Iryna")
    public void testIncorrectPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        loginPage.logIn("standard_user", "4444");
        Assert.assertTrue(loginPage.isPageOpened(), "Log In Page is not opened");
        String expectedUrl = "https://www.saucedemo.com";
        Assert.assertTrue(loginPage.getCurrentUrl().contains(expectedUrl));
        Assert.assertTrue(loginPage.getPageSource().contains("Epic sadface: Username and password do not match any user in this service"));
    }


    @Test
    public void testAddToCart() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Log In Page is not opened");
        InventoryPage inventoryPage = loginPage.logIn("standard_user", "secret_sauce");
        int selectedProduct = 3;
        String expectedInventoryItem = inventoryPage.inventory.inventoryNames.get(selectedProduct).getText();
        String expectedInventoryPrice = inventoryPage.inventory.inventoryPrice.get(selectedProduct).getText();
        inventoryPage.inventory.addButton.get(selectedProduct).click();
        CartPage cartPage = inventoryPage.openCart();
        SoftAssert softAssert = new SoftAssert();
        String actualCartItem = cartPage.cart.cartItemNames.get(0).getText();
        String actualCartPrice = cartPage.cart.cartItemPrices.get(0).getText();
        softAssert.assertEquals(actualCartItem, expectedInventoryItem);
        softAssert.assertEquals(actualCartPrice, expectedInventoryPrice);
        softAssert.assertAll();

    }

    @Test
    public void testOpenItemAndLogOut() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Log In Page is not opened");
        InventoryPage inventoryPage = loginPage.logIn("standard_user", "secret_sauce");
        int chosenItem = 1;
        String expectedChosenItemName = inventoryPage.inventory.inventoryNames.get(chosenItem).getText();
        String expectedChosenItemPrice = inventoryPage.inventory.inventoryPrice.get(chosenItem).getText();
        InventoryInfoPage inventoryInfoPage = inventoryPage.choseItem(chosenItem);
        SoftAssert softAssert = new SoftAssert();
        String actualChosenItemName = inventoryInfoPage.inventoryInfoItem.chosenItemName.getText();
        String actualChosenItemPrice = inventoryInfoPage.inventoryInfoItem.chosenItemPrice.getText();
        softAssert.assertEquals(actualChosenItemName, expectedChosenItemName);
        softAssert.assertEquals(actualChosenItemPrice, expectedChosenItemPrice);
        softAssert.assertAll();
        inventoryInfoPage.back();
        inventoryPage.burgerButton();
        inventoryPage.logOut();
        String expectedUrl = "https://www.saucedemo.com";
        Assert.assertTrue(loginPage.getCurrentUrl().contains(expectedUrl));
    }

    @Test
    public void testSorting() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Log In Page is not opened");
        InventoryPage inventoryPage = loginPage.logIn("standard_user", "secret_sauce");

        List<String> inventoryNames = getInventoryNames(inventoryPage.inventory.inventoryNames);
        List<BigDecimal> inventoryPrice = getInventoryPrices(inventoryPage.inventory.inventoryPrice);

        List<String> sortedItemsAtoZ = inventoryNames.stream().sorted().collect(Collectors.toList());//sort A to Z check
        inventoryPage.sortAtoZ();
        List<String> actualSortedAtoZ = getInventoryNames(inventoryPage.inventory.inventoryNames);
        Assert.assertEquals(actualSortedAtoZ, sortedItemsAtoZ);

        List<String> sortedItemsZtoA = inventoryNames.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        inventoryPage.sortZtoA();
        List<String> actualSortedZtoA = getInventoryNames(inventoryPage.inventory.inventoryNames);
        Assert.assertEquals(actualSortedZtoA, sortedItemsZtoA);

        List<BigDecimal> sortedLowToHigh = inventoryPrice.stream().sorted().collect(Collectors.toList());
        inventoryPage.sortLowToHigh();
        List<BigDecimal> actualSortedLowToHigh = getInventoryPrices(inventoryPage.inventory.inventoryPrice);
        Assert.assertEquals(actualSortedLowToHigh, sortedLowToHigh);

        List<BigDecimal> sortedHighToLow = inventoryPrice.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        inventoryPage.sortHighToLow();
        List<BigDecimal> actualSortedHighToLow = getInventoryPrices(inventoryPage.inventory.inventoryPrice);
        Assert.assertEquals(actualSortedHighToLow, sortedHighToLow);
    }

    private  List<BigDecimal> getInventoryPrices(List<ExtendedWebElement> inventoryPrices) {
        return inventoryPrices.stream()
                .map(price -> new BigDecimal(price.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    private List<String> getInventoryNames(List<ExtendedWebElement> inventoryNames) {
        return inventoryNames.stream()
                .map(ExtendedWebElement::getText)
                .collect(Collectors.toList());
    }

}




