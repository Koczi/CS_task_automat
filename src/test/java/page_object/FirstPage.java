package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage {
    WebDriver driver;

    public FirstPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "id_first_name")
    WebElement firstNameInput;

    @FindBy(id = "id_last_name")
    WebElement lastNameInput;

    @FindBy(id = "id_email")
    WebElement emailInput;

    @FindBy(id = "id_phone")
    WebElement phoneInput;

    @FindBy(id = "id_pesel")
    WebElement peselInput;

    @FindBy(id = "id_id_numer")
    WebElement idNumberInput;

    @FindBy(id = "id_date")
    WebElement bornDateInput;

    @FindBy(id = "form_button_next")
    WebElement nextBtn;

//    By firstNameInput = By.id("id_first_name");
//    By lastNameInput = By.id("id_last_name");
//    By emailInput = By.id("id_email");
//    By phoneInput = By.id("id_phone");
//    By peselInput = By.id("id_pesel");
//    By idNumberInput = By.id("id_id_numer");
//    By bornDateInput = By.id("id_date");
//    By nextBtn = By.id("form_button_next");

    public void sendForm(String firstName, String lastName, String email, String phone, String pesel, String idNumber, String bornDate){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phone);
        peselInput.sendKeys(pesel);
        bornDateInput.sendKeys(bornDate);
        idNumberInput.sendKeys(idNumber);
        nextBtn.click();
    }
}