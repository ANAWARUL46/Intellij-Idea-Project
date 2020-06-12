package test;

import base.BaseClass;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.FacebookPage;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyFile;

public class FacebookTest extends BaseClass {
    @Test
    public void FacebookSignUp() throws IOException {
        test=report.createTest("Facebook SignUp");
        FacebookPage fp= PageFactory.initElements(driver,FacebookPage.class);
        driver.get("https://www.facebook.com/r.php");

       fp.enterFirstName("Anwar");
       fp.enterLastName("Islam");
       fp.enterEmail("a@yahoo.com");
       fp.enterAgainEmail("a@yahoo.com");
       fp.enterPassword("123456");
       fp.enterMonth("Jan");
       fp.enterDay("10");
       fp.enterYear("2000");
       fp.clickOnMale();
       fp.clickOnSignup();


        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f,new File(System.setProperty("user.dir", "C:\\Users\\ANAWA\\OneDrive\\Desktop\\Alif")));
    }
}
