package test;

import base.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BMICalculatePage;

public class BMICalculateTest extends BaseClass {

    @Test
            public void NoHeightField() {
        test=report.createTest("No Value in Height Field");
        BMICalculatePage bcp = PageFactory.initElements(driver, BMICalculatePage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/BMI.html");
        bcp.enterHeight("");
        bcp.enterweight("50");
        bcp.ClickOnCalculate();
        bcp.verifyBMI("");
        bcp.verifyCategory("");
        bcp.verifyMessage("Please enter Height");
    }
    @Test
    public void NoWeightField() {
        test=report.createTest("No Value in Weight Field");
        BMICalculatePage bcp = PageFactory.initElements(driver, BMICalculatePage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/BMI.html");
        bcp.enterHeight("170");
        bcp.enterweight("");
        bcp.ClickOnCalculate();
        bcp.verifyBMI("");
        bcp.verifyCategory("");
        bcp.verifyMessage("Please enter Weight");
    }
    @Test
    public void CategoryNormal() {
        test=report.createTest("Category Normal");
        BMICalculatePage bcp = PageFactory.initElements(driver, BMICalculatePage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/BMI.html");
        bcp.enterHeight("170");
        bcp.enterweight("60");
        bcp.ClickOnCalculate();
        bcp.verifyBMI("20.8");
        bcp.verifyCategory("Normal");

    }
    @Test
    public void CategoryUnderWeight() {
        test=report.createTest("Category UnderWeight");
        BMICalculatePage bcp = PageFactory.initElements(driver, BMICalculatePage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/BMI.html");
        bcp.enterHeight("170");
        bcp.enterweight("50");
        bcp.ClickOnCalculate();
        bcp.verifyBMI("17.3");
        bcp.verifyCategory("Underweight");

    }
    @Test
    public void CategoryOverWeight() {
        test=report.createTest("Category OverWeight");
        BMICalculatePage bcp = PageFactory.initElements(driver, BMICalculatePage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/BMI.html");
        bcp.enterHeight("170");
        bcp.enterweight("80");
        bcp.ClickOnCalculate();
        bcp.verifyBMI("27.7");
        bcp.verifyCategory("Overweight");

    }
    @Test
    public void CategoryObesity() {
        test=report.createTest("Category Obesity");
        BMICalculatePage bcp = PageFactory.initElements(driver, BMICalculatePage.class);
        driver.get("file:///C:/Users/ANAWA/OneDrive/Desktop/BMI.html");
        bcp.enterHeight("170");
        bcp.enterweight("90");
        bcp.ClickOnCalculate();
        bcp.verifyBMI("31.1");
        bcp.verifyCategory("Obesity");

    }



}
