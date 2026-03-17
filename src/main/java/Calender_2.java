import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Calender_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://in-house-staging.tekark.com/site-admin/login");

        String month = "July";
        String date = "July 7";
        String year = "2027";

        String FullDate = date+", " + year;

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@yopmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456789");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.findElement(By.xpath("//span[text()='Programs']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Live Programs']")));
        menu.click();

        driver.findElement(By.xpath("//input[@id='filterProgramDate']")).click();

        driver.findElement(By.xpath("(//div[contains(@class,'flatpickr-calendar')]//select[@aria-label='Month'])[2]")).click();

        driver.findElement(By.xpath("(//select[@aria-label='Month'])[2]/option[text()='"+month+"']")).click();

        driver.findElement(By.xpath("(//div[@class='numInputWrapper']//input[@type='number'])[2]")).click();

        driver.findElement(By.xpath("(//div[@class='numInputWrapper']//input[@type='number'])[2]")).sendKeys(year);

        driver.findElement(By.xpath("//span[@aria-label='"+FullDate+"']")).click();
        driver.quit();
    }
}
