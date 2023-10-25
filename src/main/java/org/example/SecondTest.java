package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.Duration;

public class SecondTest {
    protected static WebDriver driver;
    public static void clickonelements(By by)
    {
       driver.findElement(by).click();
    }

    public static void typetext (By by, String text)
    {
      driver.findElement(by).sendKeys(text);
    }
    public static String getreturntext(By by)
    {
      return driver.findElement(by).getText();
    }
    public static void waitForClickable(By by, int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static void waitForElementToBeVisible(By by,int time)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public static void waitForElementToBeInvisible(By by, int time)
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
      wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public static void waitForElementtobeDisappear(By by,int time)
    {
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
      wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(by)));
    }
    public static void waitUrlToBe(int time)
    {
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
       wait.until(ExpectedConditions.urlToBe(driver.getCurrentUrl()));
    }
    public static String timeStamp() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        // setting for chrome browser run
        driver = new ChromeDriver();
        // implicitly wait for each command
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // maximize full web screen
        driver.manage().window().fullscreen();
        //open url
        driver.get("https://demo.nopcommerce.com/");
        //click on register button
        waitForClickable(By.linkText("Register"),10);
        // driver.findElement(By.linkText("Register")).click();
        clickonelements(By.linkText("Register"));
        //enter firstname
        // driver.findElement(By.id("FirstName")).sendKeys("Nick");
        typetext(By.id("FirstName"),"Nick");
        //enter lastname
        //driver.findElement(By.id("LastName")).sendKeys("Jonas");
        typetext(By.id("LastName"),"Jonas");
        //Dropdown Day
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByValue("6");
        //Dropdown Month
        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByVisibleText("March");
        //Dropdown Year
        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByValue("1927");
        // enter email adress
        //driver.findElement(By.name("Email")).sendKeys("nickjonas" +timeStamp()+"@gmail.com");
        typetext(By.name("Email"),"nickjonas" +timeStamp()+"@gmail.com");
        // enter companyname
        // driver.findElement(By.id("Company")).sendKeys("Dichman");
        typetext(By.id("Company"),"Dichman");
        //click on newsetter
        // driver.findElement(By.xpath("//*[@id=\"Newsletter\"]")).click();
        clickonelements(By.xpath("//*[@id=\"Newsletter\"]"));
        //enter password
        // driver.findElement(By.id("Password")).sendKeys("Test1234");
        typetext(By.id("Password"),"Test1234");
        //enter confirm password
        //driver.findElement(By.name("ConfirmPassword")).sendKeys("Test1234");
        typetext(By.name("ConfirmPassword"),"Test1234");
        //click on register button
        //driver.findElement(By.id("register-button")).click();
        clickonelements(By.id("register-button"));
        // String registerText =driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        //  System.out.println(registerText);
        System.out.println(getreturntext(By.xpath("//div[@class=\"result\"]")));
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
