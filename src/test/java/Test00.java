import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Test00 {

    @Test
    public void test00() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();

        driver.quit();

    }


    @Test
    public void test01() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();


        // Implicit wait

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        // Explicit wait

        // sleep(7000);

        WebElement logout = driver.findElement(By.linkText("Logout"));

        Assert.assertTrue(logout.isDisplayed());

        // By.linkText("button")
        // sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout")));

        WebElement submitButton2 = driver.findElement(By.linkText("Logout"));

        driver.quit();

    }


    @Test
    public void testImdb00() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.imdb.com/");

        sleep(3000);

        // WebElement menuButton = driver.findElement(By.cssSelector(".ipc-responsive-button__text"));
        WebElement menuButton = driver.findElement(By.xpath("//*[@class='ipc-responsive-button__text']"));

        menuButton.click();

        sleep(5000);

        driver.quit();

    }


}
