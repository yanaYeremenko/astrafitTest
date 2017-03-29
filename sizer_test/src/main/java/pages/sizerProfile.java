package pages;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class sizerProfile {

    public static SelenideElement textAfterRequest = $(".success");


    @Step
    public static void goToMyProfile() {
        $(".dropdown>a").click();
    }

    @Step
    public static void pressChangeMyParameters() {
        $(".btn.btn-link.changeParams").shouldBe(visible).click();
    }

    @Step
    public static void pressRegister() {
        $(".btn.btn-link.register.text-lowercase").click();
    }

    @Step
    public static void pressForgotPassword() {
        $(".forgot").click();
    }

    @Step
    public static void pressButtonSignIn(){
        $(".field .btn.btn-success").click();
    }

    @Step
    public static void pressButtonSignOut() {
        $(".btn.btn-success.exit.text-uppercase").click();
    }

    @Step
    public static void pressButtonSend(){
        $(".field .btn.btn-success").click();
    }

    @Step
    public static void checkLoginUser(){
        $(".user-status.user-exist");
    }

    @Step
    public static void enterEmailForRecoverPassword(String email){
        $(".form-control").shouldBe(type("email")).setValue(email);
    }

    @Step
    public static void enterEmailForLogin(String email) {
        $("[type='email']").setValue(email);
    }

    @Step
    public static void enterPasswordForLogin(String password) {
        $("[type='password']").setValue(password);
    }

    @Step
    public static void chooseLanguage(String lenguage) {
        $(byText(lenguage)).click();
    }
}
