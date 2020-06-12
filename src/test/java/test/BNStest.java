package test;

import base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BNSpage;

import java.io.File;
import java.io.IOException;

public class BNStest extends BaseClass {
    @Test
    public void RegistrationForm() throws IOException {
        test=report.createTest("Registration Form");
        BNSpage bnsp= PageFactory.initElements(driver,BNSpage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/BNS.html");

        bnsp.enterFirstName("Anwar");
        bnsp.enterLastName("Islam");
        bnsp.enterEmail("Anwar@yahoo.com");
        bnsp.enterPassword("1234");
        bnsp.enterPhoneNumber("123455");
        bnsp.selectmonth("Jan");
        bnsp.selectday("10");
        bnsp.selectyear("2001");
        bnsp.clickOnMale();
        bnsp.clickOnSubmit();
        bnsp.verifyText("Submitted Form Data");

        //File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"\\ScreenShot\\Anwar.png"));

        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File(System.setProperty("user.dir", "C:\\Users\\ANAWA\\OneDrive\\Desktop\\Alif")));
    }

}
