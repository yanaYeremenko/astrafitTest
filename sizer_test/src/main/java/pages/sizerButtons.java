package pages;

import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by yana on 30.11.15.
 */
public class sizerButtons {

    @Step
    public static void pressWidgetButton() {
        $(".af-btn.af-btn-primary.af-btn-md.af-btn-with-logo.af-btn-with-desc").shouldBe(visible).click();
    }

    @Step
    public static void pressWidgetButtonWithScore(){
        $(".af-btn.af-btn-with-logo.af-btn-primary.af-btn-md.af-btn-with-desc.af-btn-with-color.ui-rate-recommend").click();
    }

}
