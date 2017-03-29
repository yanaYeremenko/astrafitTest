package pages;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class sizerRegistration {

    public static SelenideElement textInRegisterForm = $(".desc");

    @Step
    public static void goToUserAgreement() {
        $(".userAgreement").click();
    }

    @Step
    public static void pressButtonSaveEmailandParams() {
        $(".form-control.input-lg.email").click();
    }

    @Step
    public static void pressIhaveGotItRU() {
        $$(".btn.btn-success.thanx").find(text("Спасибо, прочел")).click();
    }

    @Step
    public static void pressIhaveGoItEN() {
        $$(".btn.btn-success.thanx").find(text("I've got it!")).click();
    }

    @Step
    public static void pressContinueWithoutRegistration() {
        $(".btn.btn-link.btn-lg.continue a").click();
    }

    @Step
    public static void closeUserAgreementRU() {
        $("div.close").hover().click();
    }

    @Step
    public static void closeUserAgreementEN(){
        $$("div.close").find(text("Close")).hover().click();
    }


}
