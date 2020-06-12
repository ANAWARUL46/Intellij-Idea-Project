package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FundTransferPage {
    @FindBy(xpath="//*[@id=\"payee\"]")
    WebElement payee;
    public void selectPayeeName(String pye) {
        Select payeeSelect=new Select(payee);
        payeeSelect.selectByVisibleText(pye);
    }
    @FindBy(xpath="//*[@id=\"amount\"]")
    WebElement amount;
    public void enterAmount(String amt) {
        amount.sendKeys(amt);
    }
    @FindBy(xpath="//*[@id=\"balance\"]")
    WebElement balance;
    public void verifyBalance(String bln) {
        String actualBalance=balance.getAttribute("value");
        Assert.assertEquals(actualBalance, bln);
    }
    @FindBy(xpath="//*[@id=\"transfer\"]")
    WebElement transfer;
    public void clickOnTransfer() {
        transfer.click();
    }
    @FindBy(xpath="//*[@id=\"message\"]")
    WebElement FailMessage;
    public void verifyFailMessage(String sms) {
        String ActualFailMessage=FailMessage.getText();
        Assert.assertEquals(ActualFailMessage, sms);
    }
    @FindBy(xpath="//*[@id=\"message\"]")
    WebElement sucsMessage;
    public void verifySuccessMessage(String sms) {
        String ActualSuccessMessage=sucsMessage.getText();
        Assert.assertEquals(ActualSuccessMessage, sms);
    }
    @FindBy(xpath="//*[@id=\"message\"]")
    WebElement WarningMessage;
    public void verifyWarningMessage(String sms) {
        String ActualWarningMessage=WarningMessage.getText();
        Assert.assertEquals(ActualWarningMessage, sms);
    }
}
