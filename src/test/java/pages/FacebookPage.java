package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FacebookPage {
    @FindBy(name="firstname")
    WebElement firstname;
    public void enterFirstName(String fn) {firstname.sendKeys(fn); }

    @FindBy(name="lastname")
    WebElement lastname;
    public void enterLastName(String ln) {lastname.sendKeys(ln);}

    @FindBy(name="reg_email__")
    WebElement email;
    public void enterEmail(String em) {email.sendKeys(em);}

    @FindBy(name="reg_email_confirmation__")
    WebElement aemail;
    public void enterAgainEmail(String aem) {aemail.sendKeys(aem);}

    @FindBy(name="reg_passwd__")
    WebElement password;
    public void enterPassword(String pw) {password.sendKeys(pw);}

    @FindBy(xpath ="//*[@id=\"month\"]")
    WebElement month;
    public void enterMonth(String mn) {
        Select monthselect=new Select(month);
        monthselect.selectByVisibleText(mn);
    }

    @FindBy(xpath="//*[@id=\"day\"]")
    WebElement day;
    public void enterDay(String dy) {
        Select dayselect= new Select(day);
        dayselect.selectByVisibleText(dy);
    }
    @FindBy(xpath = "//*[@id=\"year\"]")
    WebElement year;
    public void enterYear(String yr) {
        Select yearselect = new Select(year);
        yearselect.selectByVisibleText(yr);
    }

    @FindBy(xpath ="//*[@id=\"u_0_7\"]")
    WebElement male;
    public void clickOnMale() {male.click();}

    @FindBy(xpath ="//*[@id=\\\"u_0_6\\\"]")
    WebElement female;
    public void clickOnFemale() {female.click();}

    @FindBy(xpath ="//*[@id=\\\"u_0_8\\\"]")
    WebElement custom;
    public void clickOnCustom() {custom.click();}

    @FindBy(xpath ="//*[@id=\"u_0_13\"]")
    WebElement signup;
    public void clickOnSignup() {signup.click();}

    @FindBy(xpath ="//*[@id=\"u_0_13\"]")
    WebElement text;
    public void verifyMessage(String sms) {
        Assert.assertEquals(text.getText(),sms);
    }


}
