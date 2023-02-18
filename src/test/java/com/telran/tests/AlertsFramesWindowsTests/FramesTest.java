package com.telran.tests.AlertsFramesWindowsTests;

import com.telran.pages.AlertsFrameWindowsPages.FramesPage;
import com.telran.pages.BookStore.BookStorePage;
import com.telran.pages.HomePage;
import com.telran.tests.TestBase;
import com.telran.pages.SideMenu;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openAlertsFrameWindowsPage();
        new SideMenu(driver).openFramesPage();
    }

   @Test(enabled = false) // не можем корректно выполнить из-за окон рекламы
    public void ensureNumberOfFrames(){
        Assert.assertEquals(new FramesPage(driver).getFramesNumber(), 2);
    }

    @Test
    public void switchToFrameByID() {
        Assert.assertTrue( new FramesPage(driver).switchToFrameByID().getH1().contains("sample"));
    }
}
