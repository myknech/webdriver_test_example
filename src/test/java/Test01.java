import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Test01 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        driver.manage().window().maximize();
    }

    @Test
    public void demoQA01() throws InterruptedException {


        driver.get("https://demoqa.com/automation-practice-form");

        sleep(2500);

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Kumar");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Krishna");

        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("abc@abc.com");

        WebElement mobileNumber = driver.findElement(By.id("userNumber"));
        mobileNumber.sendKeys("1234567890");

        WebElement gender = driver.findElement(By.xpath("//label[text()='Other']"));
        gender.click();

        // Пытаемся убить рекламу через джаваскрит.

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement buttonSubmit = driver.findElement(By.id("submit"));

        executor.executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);

        sleep(2000);

        executor.executeScript("$('footer').remove();");
        executor.executeScript("$('#fixedban').remove();");
        executor.executeScript("$('iframe').remove();");


        buttonSubmit.click();


        WebElement buttonClose = driver.findElement(By.id("closeLargeModal"));
        Assert.assertTrue(buttonClose.isDisplayed());

        executor.executeScript("arguments[0].scrollIntoView(true);", buttonClose);

        // buttonClose.click();

        executor.executeScript("$('#closeLargeModal').click();");

        sleep(7000);

    }


    @Test
    public void testName00() {
        driver.get("https://demoqa.com/automation-practice-form");
    }


    @Test
    public void testName01() {
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
