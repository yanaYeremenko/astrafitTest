package GmailTest;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static GmailTest.Config.login;
import static GmailTest.Config.password;
/**
 * Created by yana on 25.05.15.
 */
public class LoginGmail {


    @Test
    public void testGmailLogin(){
      open("https://www.gmail.com/");
      Configuration.timeout = 20000;

        $("#Email").setValue(login).pressEnter();
        $("#Passwd").setValue(password).pressEnter();

        $(byText("НАПИСАТЬ")).shouldBe(visible).click();

        $(By.name("to")).setValue(login);
        $(By.name("subjectbox")).setValue("Привет");

        $(".Am.Al.editable.LW-avf").setValue("ку ку ку");

        $(byText("Отправить")).click();
        $("[href$='inbox']").click();
        $$(".y6").get(0).shouldHave(text("Привет"));
    }
}
