package test;

import base.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.SuperTechPage;

public class SuperTechTest extends BaseClass {
    @Test
    public void SuperTech() throws InterruptedException {
        test=report.createTest("Demo Website");
        SuperTechPage stp= PageFactory.initElements(driver,SuperTechPage.class);
        driver.get("https://bnscorporation.com/demo-website/");

        stp.enterFirstName("Anwar");
        stp.enterLastName("Islam");
        stp.enterEmail("a@gmail.com");
        stp.enterPassword("123");
        stp.enterPhone("123456");
        stp.selectMonth("Jan");
        stp.selectDay("10");
        stp.selectYear("2001");
        stp.clickOnMale();
        stp.verifyCheckBoxIsSelected();
        Thread.sleep(10000);
        stp.clickOnSubmit();
        stp.verifyText("Submitted Form Data");
    }
}
