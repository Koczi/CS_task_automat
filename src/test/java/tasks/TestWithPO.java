package tasks;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import page_object.FirstPage;
import page_object.SecondPage;

public class TestWithPO {

    private WebDriver driver;
    FirstPage firstPage;
    SecondPage secondPage;
    Faker faker = new Faker();

    @BeforeClass
    public void setupClass()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        firstPage = new FirstPage(driver);
        secondPage = new SecondPage(driver);
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
    public void firstStepWithPO() {
        String imie = faker.name().firstName();
        String nazwisko = faker.name().lastName();
        String mail = faker.internet().emailAddress();
        String telefon = "123456789";
        String pesel = "26081224605";
        String dowod = "AVD683625";
        String urodziny = "2021-07-01";


        firstPage.sendForm(imie,nazwisko,mail,telefon,pesel,dowod,urodziny);
        secondPage.confirmSecondPage();
    }
}
