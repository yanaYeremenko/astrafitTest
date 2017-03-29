package pages;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class sizerMeasurements {

    public static SelenideElement selectedParamater = $(".active .my");

    @Step
    public static void goToMeasurements() {
        $(".tableMenu>a").click();
    }

    @Step
    public static void chooseFromTableList(String nameList) {
        $(byText(nameList)).hover();
    }

    @Step
    public static void pressButtonSaveMyData() {
        $(".btn.btn-success.btn-lg.next").pressEnter();
    }

    @Step
    public static void closeWidget(){
        $(".main-close.close-window").click();
    }

    @Step
    public static void changeParametersFromTable(String nameList) {
        $(byText(nameList)).hover();
        selectedParamater.click();
    }
}
