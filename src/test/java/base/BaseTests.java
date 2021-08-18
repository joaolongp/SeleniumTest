package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseTests {

    private static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

//    @After
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Test
    public void fillAllFieldsTest() {
        driver.get("http://way2automation.com/way2auto_jquery/index.php");
        driver.findElement(By.name("name")).sendKeys("joao");
        driver.findElement(By.name("phone")).sendKeys("1234567890");
        driver.findElement(By.name("email")).sendKeys("joao@email.com");
        driver.findElement(By.name("city")).sendKeys("Porto Alegre");

        Select dropdown = new Select(driver.findElement(By.name("country")));
        dropdown.selectByVisibleText("Brazil");

        driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[6]/input")).sendKeys("joaouser");
        driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input")).sendKeys("joaopassword");

        driver.findElement(By.cssSelector("#load_form > div:nth-child(12) > div.span_1_of_4 > input")).click();
    }
}
