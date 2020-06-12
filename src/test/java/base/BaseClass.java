package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseClass {
    protected static WebDriver driver;

    protected static ExtentHtmlReporter extHtmlreport;
    protected static ExtentReports report;
    protected static ExtentTest test;




    @BeforeTest
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

        extHtmlreport= new ExtentHtmlReporter(System.getProperty("user.dir")+"\\test-output\\ExtentReport.html");
        extHtmlreport.config().setDocumentTitle(" Testng Exten Report");
        extHtmlreport.config().setReportName("Autamation Testing Report");
        extHtmlreport.config().setTheme(Theme.STANDARD);

        report=new ExtentReports();
        report.attachReporter(extHtmlreport);
        report.setSystemInfo("Hostname", "LocaHost");
        report.setSystemInfo("OS", "Windows10");
        report.setSystemInfo("Browser Name", "Chrome");
        report.setSystemInfo("Tester Name", "Anwar Islam");

    }
    @AfterMethod
    public void extenStatus(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE) {
            test.log(Status.FAIL, "Failed Test case is :"+result.getName() );
            test.log(Status.FAIL, "Failed Test case is :"+result.getThrowable() );

            String screenshotpath=getScreenShot(result.getName());
            test.addScreenCaptureFromPath(screenshotpath);
        }

        else if(result.getStatus()==ITestResult.SKIP) {
            test.log(Status.SKIP, "Skiped Test case is :"+result.getName() );
        }
        else if(result.getStatus()==ITestResult.SUCCESS) {
            test.log(Status.PASS, "Passed Test case is :"+result.getName() );
        }
    }

    public static String getScreenShot(String screenShotName) throws IOException {
        String dateName=new SimpleDateFormat("yyyy-MM-dd-/hh-mm-ss").format(new Date());

        File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destination=System.getProperty("user.dir")+"\\ScreenShot\\"+screenShotName+dateName+".png";
        FileUtils.copyFile(f, new File(destination));
        return destination;
    }

    @AfterTest
    public void teardown() {
        report.flush();
        driver.close();;
    }


}
