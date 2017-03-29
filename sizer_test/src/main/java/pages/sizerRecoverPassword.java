package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class sizerRecoverPassword {

    public static SelenideElement inbox = $("[href$='inbox']");
    public static String email = "astrafitqafortest@gmail.com";
    public static String passworGmail = "astrafit";

    @Step
    public static void pressSaveRecoverPassword(){
        $(".button").click();
    }

    @Step
    public static void pressComeBackToSite(){
        $(".success>span>a").click();
    }

    @Step
    public static void enterNewPassword(String newPassword){
        $(".password1").setValue(newPassword);
    }

    @Step
    public static void enterConfirmPassword(String newConfirmPassword){
        $(".password2").setValue(newConfirmPassword);
    }

    @Step
    public static void deleteLetter(){
        open("https://www.gmail.com/");
        Configuration.timeout = 20000;

        $(byText("COMPOSE")).shouldBe(visible);

        $$(".T-Jo-auh").get(1).click();
        $(".T-I.J-J5-Ji.nX.T-I-ax7.T-I-Js-Gs.ar7").click();
    }
}
