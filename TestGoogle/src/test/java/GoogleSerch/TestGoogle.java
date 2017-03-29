package GoogleSerch;


import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class TestGoogle {
    WebDriver driver = new FirefoxDriver();

    @Before
    public  void openBrowse(){
        driver.get("https://www.google.com/ncr");
    }
    @After
    public  void  closeBrowse(){
        driver.close();
    }

    @Test
    public void testGoogleSerch(){

        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Selenium" + Keys.ENTER);
        (new WebDriverWait(driver, 10)).until(textToBePresentInElementLocated(
                By.cssSelector("#ires li.g:nth-child(9)"), "A browser automation framework"));
    }
}
