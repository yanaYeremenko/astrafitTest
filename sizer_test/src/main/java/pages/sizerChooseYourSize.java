package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class sizerChooseYourSize {

    public static SelenideElement helpText = $(".title.title-right");
    public static ElementsCollection discriptionText = $$(".text>h4");

    @Step
    public static void goToChooseMySize() {
        $(".chooseMenu>a").click();
    }

    @Step
    public static void addParameter(String fieldName,String number) {
        $$(".field-container").find(text(fieldName)).find(".input>input").setValue(number);
    }

    @Step
    public  static void editParameters(String fieldName, String newNumber ){
        $$(".field-container").find(text(fieldName)).find(".input>input").setValue(newNumber);
    }

    @Step
    public static void checkEmptyParamsField(String fieldName) {
        $$(".field-container").find(text(fieldName)).find(".input>input").shouldBe(empty).click();
    }

    @Step
    public static void pressButtonDone() {
        $(".btn.btn-success.btn-lg.next").pressEnter();
    }

    @Step
    public static void pressButtonNext() {
        $(".btn.btn-success.btn-lg.next").pressEnter();
    }

    @Step
    public static void changeParametersFromRegister() {
        $(".back .btn.btn-link.btn-lg").click();
    }

    @Step
    public static void checkParameters(String fieldName, String value){
        $$(".field-container").find(text(fieldName)).find(".input>input").shouldHave(value(value));
    }

    @Step
    public static void checkTextUnderPerametersRU() {
        $(".col-xs-12.save>p").shouldHave(text("Мы измерили все изделия вручную и поэтому для нас так важно знать вашу фигуру. В результате вы сможете на 99% быть уверены в вашем размере."));
    }

    @Step
    public static void checkTextUnderParametersEN() {
        $(".col-xs-12.save>p").shouldHave(text("You'll see which size fits you best right after entering your body parameters.\n" +
                "The result is 99% accurate, because it is based on individual item measurements."));
    }

    @Step
    public static void openHelpText() {
        $(".ui-help.showTip .ttl").click();
    }

    @Step
    public static void closeHelpText() {
        $(".ui-help.showTip.active .close").click();
    }

    @Step
    public static void putCursorInField(String fildName) {
        $$(".field-container").find(text(fildName)).find(".input>input").click();
    }
}

