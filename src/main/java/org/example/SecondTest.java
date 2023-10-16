package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SecondTest {
    protected static WebDriver driver;

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
        driver.findElement(By.linkText("Register")).click();
        //enter firstname
        driver.findElement(By.id("FirstName")).sendKeys("Nick");
        //enter lastname
        driver.findElement(By.id("LastName")).sendKeys("Jonas");
        // enter email adress
        driver.findElement(By.name("Email")).sendKeys("nickjonas1234@gmail.com");
        //enter companyname
        driver.findElement(By.id("Company")).sendKeys("Dichman");
        //click on newsetter
        driver.findElement(By.xpath("//*[@id=\"Newsletter\"]")).click();
        //enter password
        driver.findElement(By.id("Password")).sendKeys("Test1234");
        //enter confirm password
        driver.findElement(By.name("ConfirmPassword")).sendKeys("Test1234");
        //click on register button
        driver.findElement(By.id("register-button")).click();

        driver.close();






    }




}
