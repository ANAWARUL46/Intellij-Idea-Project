package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SuperTechPage {
    @FindBy(name ="FName")
    WebElement firstname;
    public void enterFirstName(String fn) {
        firstname.sendKeys(fn);
    }

    @FindBy(id="LN")
    WebElement lastname;
    public void enterLastName(String ln) {lastname.sendKeys(ln);}

    @FindBy(id="EM")
    WebElement email;
    public void enterEmail(String em) {email.sendKeys(em);}

    @FindBy(id="PW")
    WebElement password;
    public void enterPassword(String pw) {password.sendKeys(pw);}

    @FindBy(id="PH")
    WebElement phone;
    public void enterPhone(String ph) {phone.sendKeys(ph);}

    @FindBy(id="MN")
    WebElement month;
    public void selectMonth(String mn) {
        Select monthselect = new Select(month);
        monthselect.selectByVisibleText(mn);
    }
        @FindBy(id="DY")
        WebElement day;
        public void selectDay(String dy) {
            Select dayselect= new Select(day);
            dayselect.selectByVisibleText(dy);
    }
    @FindBy(id="YR")
    WebElement year;
    public void selectYear(String yr) {
        Select yearselect= new Select(year);
        yearselect.selectByVisibleText(yr);
    }
    @FindBy(xpath ="//*[@id=\"wppb-builder-container\"]/div[1]/div/div/div/div/div/div/div/div/div/div[2]/form/input[6]")
    WebElement male;
    public void clickOnMale() {
        male.click();
    }

    @FindBy(xpath = "//*[@id=\"wppb-builder-container\"]/div[1]/div/div/div/div/div/div/div/div/div/div[2]/form/input[8]")
    WebElement checkBoxDL;
    public void verifyCheckBoxIsSelected() {
        boolean selected=checkBoxDL.isSelected();

        Assert.assertEquals(selected,true);
    }

    @FindBy(xpath ="//*[@id=\"wppb-builder-container\"]/div[1]/div/div/div/div/div/div/div/div/div/div[2]/form/button")
    WebElement submit;
    public void clickOnSubmit() {
        submit.submit();
    }
    @FindBy(xpath ="/html/body/h1")
    WebElement verify;
    public void verifyText(String sms) {
        Assert.assertEquals(verify.getText(),sms);
    }
}
