package GmailTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static GmailTest.Config.login;
import static GmailTest.Config.password;

public class LoginGmailSelenium {

    WebDriver driver = new FirefoxDriver();

    @Before
    public  void openBrowse(){
        driver.get("https://www.gmail.com/");
    }
    @After
    public  void  closeBrowse(){
        driver.close();
    }

    @Test
    public void testLoginGmail(){

        driver.findElement(By.cssSelector("#Email")).sendKeys(login + Keys.ENTER);
        driver.findElement(By.cssSelector("#Passwd")).sendKeys(password + Keys.ENTER);




    }
}
