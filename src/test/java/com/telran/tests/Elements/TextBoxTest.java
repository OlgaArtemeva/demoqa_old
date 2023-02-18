package com.telran.tests.Elements;

import com.telran.pages.BookStore.BookStorePage;
import com.telran.pages.Elements.TextBoxPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.pages.data.TextBoxData;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TextBoxTest extends TestBase {

    // Pre-conditions: Text Box page is opened from the home page and side menu
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openTestBoxPage();
    }

    // Title: Check that div with 'output' displays correct data from input fields
    @Test
    public void simpleForm() throws IOException, UnsupportedFlavorException {

        // Step1: Fill in the full name input with John Doe value
        // Step2: Fill in the email input with john@doe.com
        // Step3: Fill in the Current Address input with "10318, Germany, Berlin, Marksburgstrasse 1" data
        // Step4: Copy value from the Current Address text area to Permanent Address textarea
        // Step5: Submit the form
        new TextBoxPage(driver).fillAndSubmitForm();

        // Expected results: All data from steps 1-4 is presents in the output div
        Assert.assertTrue(new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.FULLNAME));
        Assert.assertTrue(new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.EMAIL));
        Assert.assertTrue(new TextBoxPage(driver).checkSubmittedData().contains(TextBoxData.ADDRESS));
        Assert.assertTrue(new TextBoxPage(driver).getPermanentAdress().contains(TextBoxData.ADDRESS));
    }
}
