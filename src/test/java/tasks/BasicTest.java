package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class BasicTest {

    private WebDriver driver;

    @BeforeClass
    public void setupClass()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void setupMethod() {
        driver.get("https://app.bluealert.pl/ba/form/formularz-testowy");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void firstStep() {
        WebElement firstName = driver.findElement(By.id("id_first_name"));
        firstName.sendKeys("Imię");
        WebElement lastName = driver.findElement(By.id("id_last_name"));
        lastName.sendKeys("Nazwisko");
        WebElement email = driver.findElement(By.id("id_email"));
        email.sendKeys("test@test.pl");
        WebElement phone = driver.findElement(By.id("id_phone"));
        phone.sendKeys("123456789");
        WebElement pesel = driver.findElement(By.id("id_pesel"));
        pesel.sendKeys("26081224605");
        WebElement bornDate = driver.findElement(By.id("id_date"));
        bornDate.sendKeys("2021-07-01");
        WebElement idNumber = driver.findElement(By.id("id_id_numer"));
        idNumber.sendKeys("AVD683625");
        WebElement nextBtn = driver.findElement(By.id("form_button_next"));
        nextBtn.click();
        WebElement secondPage = driver.findElement(By.cssSelector("#fieldgroup_zgoda > div.legend"));
        Assert.assertTrue(secondPage.isDisplayed());
    }
}
