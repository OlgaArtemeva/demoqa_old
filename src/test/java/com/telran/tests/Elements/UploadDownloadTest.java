package com.telran.tests.Elements;

import com.telran.pages.AlertsFrameWindowsPages.AlertsPage;
import com.telran.pages.Elements.ButtonsPage;
import com.telran.pages.Elements.UploadDownloadPage;
import com.telran.pages.HomePage;
import com.telran.pages.SideMenu;
import com.telran.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadDownloadTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).openElements();
        new SideMenu(driver).openUploadDownloadPage();
    }

    // Title: File is downloaded after Download button is clicked
    @Test
    public void clickOnDownloadButton() {
        //Step1: double click on Download button
        //Expected result: File is downloaded locally
//   мое     String name = "sampleFile";
//   мое     Assert.assertTrue(new UploadDownloadPage(driver).getClickOnDownloadButtonResult().contains(name));
        Assert.assertTrue(new UploadDownloadPage(driver).verifyDownload());
    }

    @Test
    public void selectFileToUpload() {
        //Step1: double click on Download button
        //Expected result: File is downloaded locally
        Assert.assertTrue(new UploadDownloadPage(driver).selectFile().checkFileIsSelected());
    }

}
