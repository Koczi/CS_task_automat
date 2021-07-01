package page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SecondPage {
    WebDriver driver;

    public SecondPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#fieldgroup_zgoda > div.legend")
    WebElement secondPage;


    public void confirmSecondPage(){
        Assert.assertTrue(secondPage.isDisplayed());
    }

}