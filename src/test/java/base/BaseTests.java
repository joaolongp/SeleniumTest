package base;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTests {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void openRegisterWindowTest(){
        driver.get("http://demo.automationtesting.in/Register.html");
        Assert.assertEquals(driver.getTitle(), "Register");
    }

}
