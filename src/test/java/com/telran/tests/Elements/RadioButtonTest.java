package com.telran.tests.Elements;

import com.telran.pages.Elements.RadioButtonPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTest extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openRadioButtonPage();

    }

    @Test
    public void selectRadioButtons() {
        Assert.assertTrue( new RadioButtonPage(driver).selectYes().checkSelected().contains("Yes") );
    }
}
