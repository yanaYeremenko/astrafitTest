package ua.com.astrafit;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static pages.sizerButtons.pressWidgetButton;
import static pages.sizerButtons.pressWidgetButtonWithScore;
import static pages.sizerChooseYourSize.*;
import static pages.sizerMeasurements.closeWidget;
import static pages.sizerMeasurements.goToMeasurements;

public class SizerButtonTest {

    @Before
    public void clearCache() {
        clearBrowserCache();
    }

    @Before
    public void openPage(){
        open("http://musthave.ua/product/1107/");
        Configuration.timeout = 5000;
    }

    @Test
    public void pressButtonWithScores(){
//pre condition
        switchTo().innerFrame("af-wdgt-1");
        pressWidgetButton();
        // add params
        switchTo().innerFrame("af-sizer-frm-1");
        checkTextUnderPerametersRU();

        addParameter("Грудь", "90");
        addParameter("Талия", "60");
        addParameter("Бедра", "90");
        addParameter("Обхват руки", "25");
        addParameter("Рост", "175");
//Done and go to the illustration
        pressButtonDone();
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));
//close widget
        closeWidget();
// press button with scores
        switchTo().innerFrame("af-wdgt-1");
        pressWidgetButtonWithScore();
        switchTo().innerFrame("af-sizer-frm-1");
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));
    }

    @Test
    public void pressButtonWhatMySize(){

// press button "Подобрать размер"
        switchTo().innerFrame("af-wdgt-1");
        pressWidgetButton();

        switchTo().innerFrame("af-sizer-frm-1");
        checkTextUnderPerametersRU();
// add params
        addParameter("Грудь", "90");
        addParameter("Талия", "60");
        addParameter("Бедра", "90");
        addParameter("Обхват руки", "25");
        addParameter("Рост", "175");
//Done and go to illustration
        pressButtonDone();
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));
//go to the table
        goToMeasurements();
    }

   /* @After
    public void tearDown ()throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot ()throws IOException {
        File screenshot = Screenshots.getScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }*/
}
