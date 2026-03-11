package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Demo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://currituck-staging.tekark.com/login");

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("paresh.techark@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qwe@1234");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement UserName =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Paresh TechArk']")));

        System.out.println(UserName.getText());

        WebDriverWait toastmsg = new WebDriverWait(driver, Duration.ofSeconds(10));
        toastmsg.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'Vue-Toastification__toast')]")));

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement ProfileIcon =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='user-wrapper']")));
        ProfileIcon.click();

        //driver.findElement(By.xpath("//div[@class='user-wrapper']")).click();

        driver.quit();
    }
}
