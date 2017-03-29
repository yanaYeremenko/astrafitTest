package ua.com.astrafit;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static pages.sizerChooseYourSize.*;
import static pages.sizerMeasurements.*;
import static pages.sizerProfile.*;
import static pages.sizerRegistration.*;

public class SizerTest {

    @Before
    public void openPage() {
        open("http://sizer.astrafit.com/sizer/item/42584?view=main&code=1547&wdgtID=af-sizer-frm-1&referer=http%3A%2F%2Fmusthave.ua");
        Configuration.timeout = 10000;
        checkTextUnderPerametersRU();
    }

    @Test
    public void loginNewUser() {

//login as a new userl
        checkEmptyParamsField("Грудь");
        openHelpText();
        helpText.shouldHave(text("Обхват груди в наиболее выступающих точках\n" +
                "Лента проходит по нижней части лопаток Ноги вместе. Лента параллельно полу"));

        checkEmptyParamsField("Талия");
        helpText.shouldHave(text("Обхват талии в самом узком месте. Лента параллельно полу"));

        checkEmptyParamsField("Бедра");
        helpText.shouldHave(text("Обхват бедер в наиболее выступающих точках\n" +
                "Ноги вместе Лента параллельно полу"));

        checkEmptyParamsField("Обхват руки");
        helpText.shouldHave(text("Обхват руки в самом широком месте предплечья Рука прижата к туловищу"));

        checkEmptyParamsField("Рост");
        helpText.shouldHave(text("Укажите свой рост"));
        closeHelpText();

         addParameter("Грудь", "90");
         addParameter("Талия", "60");
         addParameter("Бедра", "90");
         addParameter("Обхват руки", "25");
         addParameter("Рост", "175");
        checkTextUnderPerametersRU();
        pressButtonDone();
         discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));

//go to the table
         goToMeasurements();

        chooseFromTableList("Длина изделия");
        selectedParamater.shouldHave(text("—"));

        chooseFromTableList("Обхват груди");
        selectedParamater.shouldHave(text("90"));

        chooseFromTableList("Обхват талии");
        selectedParamater.shouldHave(text("60"));

        chooseFromTableList("Обхват бедер");
        selectedParamater.shouldHave(text("90"));

        chooseFromTableList("Длина рукава");
        selectedParamater.shouldHave(text("—"));

        chooseFromTableList("Обхват рукава");
        selectedParamater.shouldHave(text("25"));

// change user's parameters from the table
         changeParametersFromTable("Обхват бедер");
        checkTextUnderPerametersRU();

        editParameters("Бедра", "100");
        editParameters("Талия", "70");
        editParameters("Рост", "170");
        pressButtonDone();

// go to Change user's parameters, but not change.
         goToMyProfile();
        pressChangeMyParameters();
        checkParameters("Грудь", "90");
        checkParameters("Талия", "70");
        checkParameters("Бедра", "100");
        checkParameters("Обхват руки", "25");
        checkParameters("Рост", "170");
        pressButtonDone();
         discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));

// change user's parameters using link"Change parameters".
         goToMyProfile();
         pressChangeMyParameters();
         editParameters("Грудь", "94");
         editParameters("Обхват руки", "27");
         pressButtonDone();
         goToMyProfile();
         pressChangeMyParameters();
         checkParameters("Грудь", "94");
         checkParameters("Талия", "70");
         checkParameters("Бедра", "100");
         checkParameters("Обхват руки", "27");
         checkParameters("Рост", "170");
         pressButtonDone();

// go to registration using LINK
         goToMyProfile();
         pressRegister();
         $(byText("Сохранить мои данные")).shouldBe(visible);

// change parameters from register form
        changeParametersFromRegister();
        checkTextUnderPerametersRU();
        editParameters("Бедра", "98");
        pressButtonNext();
        $(byText("Сохранить мои данные")).shouldBe(visible);
        changeParametersFromRegister();
        checkParameters("Грудь", "94");
        checkParameters("Талия", "70");
        checkParameters("Бедра", "98");
        checkParameters("Обхват руки", "27");
        checkParameters("Рост", "170");
        pressButtonNext();

// scan user agreement and close using Button"I've got it"
        goToUserAgreement();
        $(byText("Пользовательское соглашение")).shouldBe(visible);
        closeUserAgreementRU();
        $(byText("Сохранить мои данные")).shouldBe(visible);

// scan user agreement and close using Button "CLOSE"
        goToUserAgreement();
        pressIhaveGotItRU();

// continue without register
        pressContinueWithoutRegistration();
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));

// go to registration from Choose your size and cancel.
        pressButtonSaveMyData();
        $(byText("Сохранить мои данные")).shouldBe(visible);
        pressContinueWithoutRegistration();

//go to registration from Measurements and cancel.
        goToMeasurements();
        pressButtonSaveMyData();
        $(byText("Сохранить мои данные")).shouldBe(visible);
        pressContinueWithoutRegistration();
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));

//change language
         goToMyProfile();
         chooseLanguage("en");
         discriptionText.shouldHave(texts("Chest", "Waist", "Hips", "Sleeve width", "Length", "Sleeve length"));

// check language in the table
         goToMeasurements();

         chooseFromTableList("Length");
         chooseFromTableList("Chest circumference");
         chooseFromTableList("Waist circumference");
         chooseFromTableList("Hips circumference");
         chooseFromTableList("Sleeve length");
         chooseFromTableList("Sleeve circumference");

// check language in page with parameters
         goToMyProfile();
         pressChangeMyParameters();
         checkTextUnderParametersEN();

// check language in helpText

        putCursorInField("Chest");
        openHelpText();
        helpText.shouldHave(text("Measure around the fullest part of your chest\n" +
                "Lowest part of the shoulder blades Keep the tape parallel to the floor"));

        putCursorInField("Waist");
        helpText.shouldHave(text("Measure around the narrowest part of your waist. Keep the tape parallel to the floor. "));

        putCursorInField("Hips");
        helpText.shouldHave(text("Measure across the widest part of your hips all the way around\n" +
                "Put your legs together Keep the tape parallel to the floor"));

        putCursorInField("Arm");
        helpText.shouldHave(text("Measure around the thickest part of your upper arm Arm against to your torso"));

        putCursorInField("Height");
        helpText.shouldHave(text("Enter you height"));
        closeHelpText();
        pressButtonDone();

// check language in register form
        pressButtonSaveMyData();
        textInRegisterForm.shouldHave(text("You'll see which size fits you best right after entering your body parameters."));

// check language in user agreement
         goToUserAgreement();
         $(".agreement.eng>h2>span").shouldHave(text("Terms Of Use"));
         closeUserAgreementEN();

// check language page with parameters from register form
        changeParametersFromRegister();
        checkTextUnderParametersEN();

        putCursorInField("Chest");
        openHelpText();
        helpText.shouldHave(text("Measure around the fullest part of your chest\n" +
                "Lowest part of the shoulder blades Keep the tape parallel to the floor"));

        putCursorInField("Waist");
        helpText.shouldHave(text("Measure around the narrowest part of your waist. Keep the tape parallel to the floor. "));

        putCursorInField("Hips");
        helpText.shouldHave(text("Measure across the widest part of your hips all the way around\n" +
                "Put your legs together Keep the tape parallel to the floor"));

        putCursorInField("Arm");
        helpText.shouldHave(text("Measure around the thickest part of your upper arm Arm against to your torso"));

        putCursorInField("Height");
        helpText.shouldHave(text("Enter you height"));
        closeHelpText();
        pressButtonNext();
        textInRegisterForm.shouldHave(text("You'll see which size fits you best right after entering your body parameters."));

// change language come back EN=>RU
        goToMyProfile();
        chooseLanguage("ru");
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));
     }

    @Test
    public void loginAsRegisterUser() {
//login using email and password
        goToMyProfile();
        enterEmailForLogin("emailForTest@astrafit.com");
        enterPasswordForLogin("724500");
        pressButtonSignIn();
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));
        checkLoginUser();

// pre condition
        goToMyProfile();
        pressChangeMyParameters();
        editParameters("Грудь", "86");
        editParameters("Талия", "65");
        editParameters("Бедра", "92");
        editParameters("Обхват руки", "25");
        editParameters("Рост", "170");
        pressButtonDone();
        goToMeasurements();
        changeParametersFromTable("Обхват бедер");
        checkParameters("Грудь", "86");
        checkParameters("Талия", "65");
        checkParameters("Бедра", "92");
        checkParameters("Обхват руки", "25");
        checkParameters("Рост", "170");
        pressButtonDone();

//go to the table and come bac
        goToMeasurements();
        chooseFromTableList("Длина изделия");
        selectedParamater.shouldHave(text("—"));

        chooseFromTableList("Обхват груди");
        selectedParamater.shouldHave(text("86"));

        chooseFromTableList("Обхват талии");
        selectedParamater.shouldHave(text("65"));

        chooseFromTableList("Обхват бедер");
        selectedParamater.shouldHave(text("92"));

        chooseFromTableList("Длина рукава");
        selectedParamater.shouldHave(text("—"));

        chooseFromTableList("Обхват рукава");
        selectedParamater.shouldHave(text("25"));

        goToChooseMySize();
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));

// change parameters from the table
        goToMeasurements();
        changeParametersFromTable("Обхват груди");
        checkTextUnderPerametersRU();
        editParameters("Грудь", "88");
        editParameters("Рост", "171");
        editParameters("Обхват руки", "24");
        pressButtonDone();
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));

// go to Change user's parameters, but not change.
        goToMyProfile();
        pressChangeMyParameters();
        checkParameters("Грудь", "88");
        checkParameters("Талия", "65");
        checkParameters("Бедра", "92");
        checkParameters("Обхват руки", "24");
        checkParameters("Рост", "171");
        pressButtonDone();
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));

// change user's parameters using link"Change parameters".
        goToMyProfile();
        pressChangeMyParameters();
        editParameters("Грудь", "89");
        editParameters("Талия", "66");
        editParameters("Бедра", "94");
        pressButtonDone();
        goToMyProfile();
        pressChangeMyParameters();
        checkParameters("Грудь", "89");
        checkParameters("Талия", "66");
        checkParameters("Бедра", "94");
        checkParameters("Обхват руки", "24");
        checkParameters("Рост", "171");
        pressButtonDone();
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));

//change language RU=>EN
        goToMyProfile();
        chooseLanguage("en");
        discriptionText.shouldHave(texts("Chest", "Waist", "Hips", "Sleeve width", "Length", "Sleeve length"));

//check language in Measurement
        goToMeasurements();

        chooseFromTableList("Length");
        selectedParamater.shouldHave(text("—"));

        chooseFromTableList("Chest circumference");
        selectedParamater.shouldHave(text("89"));

        chooseFromTableList("Waist circumference");
        selectedParamater.shouldHave(text("66"));

        chooseFromTableList("Hips circumference");
        selectedParamater.shouldHave(text("94"));

        chooseFromTableList("Sleeve length");
        selectedParamater.shouldHave(text("—"));

        chooseFromTableList("Sleeve circumference");
        selectedParamater.shouldHave(text("24"));

// check language in page with parameters
        goToMyProfile();
        pressChangeMyParameters();
        checkTextUnderParametersEN();
        pressButtonDone();

// check language after refreshing page
// change language EN=>RU
        goToMyProfile();
        chooseLanguage("ru");
        discriptionText.shouldHave(texts("Грудь", "Талия", "Бедра", "Ширина рукава", "Длина изделия", "Длина рукава"));

// Sign out from widget
        goToMyProfile();
        pressButtonSignOut();
        checkTextUnderPerametersRU();
        checkEmptyParamsField("Грудь");
        checkEmptyParamsField("Талия");
        checkEmptyParamsField("Бедра");
        checkEmptyParamsField("Обхват руки");
        checkEmptyParamsField("Рост");
    }
/*
    @After
    public void tearDown ()throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot ()throws IOException {
        File screenshot = Screenshots.getScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }*/
}
