package testsuite;

import browserFactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl="https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public  void userShouldLoginSuccessfullyWithValidCredentials(){
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");
        clickOnElement(By.id("login-button"));
        String actualText= getTextFromElement(By.xpath("//span[@class='title']"));
        String expectedText="Products";
        Assert.assertEquals("Products text not displayed",actualText,expectedText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        sendTextToElement(By.id("user-name"),"standard_user");
        sendTextToElement(By.id("password"),"secret_sauce");
        clickOnElement(By.id("login-button"));
        List<WebElement> list = driver.findElements(By.className("inventory_item"));
        System.out.println("Total products are = " + list.size());
        int actual = 6;
        int expected = list.size();
        Assert.assertEquals("Size is not equal", actual, expected);

    }
}
