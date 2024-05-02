package com.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Grow {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;

    @BeforeTest
    public void before() throws Exception {
        ExtentSparkReporter exsprk = new ExtentSparkReporter(
                "D:\\Software Testing\\Model\\groww\\report\\report1.html");
        reports = new ExtentReports();
        reports.attachReporter(exsprk);
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test1() throws Exception {

        test = reports.createTest("Test 1", "Groww website calculator");
        FileInputStream fs = new FileInputStream("C:\\Users\\Nithish Kumar\\Desktop\\Model\\Model\\groww\\gr.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://groww.in/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[@id='footer']/div/div[1]/div/div[1]/div[2]/div[3]/a[2]")).click();
        Thread.sleep(3000);
        js.executeScript("window.scrollBy(0,4500)", "null");
        // driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/a[15]/div")).click();
        Thread.sleep(3000);
        // WebElement element = driver.findElement(By.);
        // element.clear();
        // element.sendKeys(loamnt);
        // element = driver.findElement(By.xpath("//*[@id='RATE_OF_INTEREST']"));
        // element.clear();
        // String loamnt = row.getCell(0).getStringCellValue();
        // String rtint = row.getCell(1).getStringCellValue();
        // String lotnt = row.getCell(2).getStringCellValue();
        // element.sendKeys(rtint);
        // element = driver.findElement(By.xpath("//*[@id='LOAN_TENURE']"));
        // element.clear();
        // element.sendKeys(lotnt);
        // String res = driver
        // .findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p"))
        // .getText();
        // Assert.assertTrue(res.contains("Details"));
        // }

        // @AfterMethod
        // public void afterTest(ITestResult result) throws Exception {
        // if (result.getStatus() == ITestResult.FAILURE) {
        // test.log(Status.FAIL, "TestCase Failed: " + result.getName());
        // test.log(Status.FAIL, "Testcase Failed Reason: " + result.getThrowable());
        // File screenshot = ((TakesScreenshot)
        // driver).getScreenshotAs(OutputType.FILE);
        // String path = "D:\\Software Testing\\Model\\groww\\report\\" +
        // result.getName() + "png";
        // FileUtils.copyFile(screenshot, new File(path));
        // test.addScreenCaptureFromPath(path);

        // } else if (result.getStatus() == ITestResult.SUCCESS) {
        // test.log(Status.PASS, "Test CAse Passed: " + result.getName());
        // } else if (result.getStatus() == ITestResult.SKIP) {
        // test.log(Status.SKIP, "Test CAse Skipped: " + result.getName());
        // }
        // }

        // @AfterTest
        // public void close() {
        // reports.flush();
        // driver.quit();
        // }
    }
}