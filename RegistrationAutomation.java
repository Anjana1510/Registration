package homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class RegistrationAutomation {

    public static void main (String args[]) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");

        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.id("gender-female")).click();

        WebElement fname = driver.findElement(By.id("FirstName"));
        WebElement lname = driver.findElement(By.id("LastName"));
        DoSendKeys(fname,"Anjana");
        DoSendKeys(lname,"Vaghasiya");

        WebElement days = driver.findElement(By.name("DateOfBirthDay"));
        WebElement months = driver.findElement(By.name("DateOfBirthMonth"));
        WebElement years = driver.findElement(By.name("DateOfBirthYear"));

        SelectElement(days,"15");
        SelectElement(months,"October");
        SelectElement(years,"1989");

        WebElement email = driver.findElement(By.id("Email"));
        DoSendKeys(email,"borad.anju11@gmail.com");

        WebElement cmpname = driver.findElement(By.id("Company"));
        DoSendKeys(cmpname,"Unify Testing");

        WebElement pwd = driver.findElement(By.id("Password"));
        WebElement confirmpwd = driver.findElement(By.id("ConfirmPassword"));
        DoSendKeys(pwd,"Practice1234");
        DoSendKeys(confirmpwd,"Practice1234");

        driver.findElement(By.id("register-button")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.className("register-continue-button")).click();

        Thread.sleep(2000);
        driver.quit();
    }

    public static void SelectElement(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public static void DoSendKeys(WebElement element, String value){
        element.sendKeys(value);
    }

}


