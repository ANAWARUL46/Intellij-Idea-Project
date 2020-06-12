package test;

import base.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.FundTransferPage;

public class FundTransferTest extends BaseClass {
    @Test
    public void ValidPayeeNoAmount() throws InterruptedException {
        test=report.createTest("No Amount");
        FundTransferPage ftp= PageFactory.initElements(driver, FundTransferPage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/fundTransfer.html");
        ftp.selectPayeeName("Jim");
        ftp.enterAmount("");
        ftp.verifyBalance("2000.00");
        ftp.clickOnTransfer();
        ftp.verifyWarningMessage("Please a valid amount");
        Thread.sleep(3000);
    }
    @Test
    public void ValidPayeeValidAmount() throws InterruptedException {
        test=report.createTest("Valid Amount");
        FundTransferPage ftp= PageFactory.initElements(driver, FundTransferPage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/fundTransfer.html");
        ftp.selectPayeeName("Jim");
        ftp.enterAmount("500");
        ftp.verifyBalance("2000.00");
        ftp.clickOnTransfer();
       ftp.verifySuccessMessage("$500 transferred successfully to Jim!!");
        Thread.sleep(3000);
    }
    @Test
    public void ValidPayeeInvalidAmount() throws InterruptedException {
        test=report.createTest("Invalid Amount");
        FundTransferPage ftp= PageFactory.initElements(driver, FundTransferPage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/fundTransfer.html");
        ftp.selectPayeeName("Jim");
        ftp.enterAmount("3000");
        ftp.verifyBalance("2000.00");
        ftp.clickOnTransfer();
        ftp.verifyFailMessage("Transfer failed!! account cannot be overdrawn");
        Thread.sleep(3000);
    }
    @Test
    public void InvalidPayeeValidAmount() throws InterruptedException {
        test=report.createTest("Invalid Payee");
        FundTransferPage ftp= PageFactory.initElements(driver, FundTransferPage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/fundTransfer.html");
        ftp.selectPayeeName("John");
        ftp.enterAmount("500");
        ftp.verifyBalance("2000.00");
        ftp.clickOnTransfer();
        ftp.verifyFailMessage("Transfer failed!! 'John' is not approved. Please contact your branch");
        Thread.sleep(3000);
    }
}
