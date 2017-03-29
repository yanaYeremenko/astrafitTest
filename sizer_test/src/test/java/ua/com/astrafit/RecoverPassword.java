package ua.com.astrafit;

import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pages.sizerButtons.pressWidgetButton;
import static pages.sizerChooseYourSize.checkEmptyParamsField;
import static pages.sizerChooseYourSize.checkTextUnderPerametersRU;
import static pages.sizerProfile.*;
import static pages.sizerRecoverPassword.*;

public class RecoverPassword {

    @Before
        public void openPage() {
        open("http://modahunt.com.ua/catalog/cardo-crd1504-4972");
        Configuration.timeout = 20000;
    }

    @Test
    public void recoverPassword() {

// change password
        switchTo().innerFrame("af-wdgt-1");
        pressWidgetButton();
        switchTo().innerFrame("af-sizer-frm-1");

        checkEmptyParamsField("Грудь");
        checkEmptyParamsField("Талия");
        checkEmptyParamsField("Бедра");
        checkEmptyParamsField("Обхват руки");
        checkEmptyParamsField("Рост");

        goToMyProfile();
        pressForgotPassword();
        enterEmailForRecoverPassword(email);
        pressButtonSend();
        textAfterRequest.shouldHave(text("Отлично! Дальнейшие инструкции высланы на указанный e-mail"));

        open("https://www.gmail.com/");
        Configuration.timeout = 20000;

        $("#Email").setValue(email).pressEnter();
        $("#Passwd").setValue(passworGmail).pressEnter();
        $(byText("НАПИСАТЬ")).shouldBe(visible);

        inbox.click();
        $$(".y6").get(0).shouldHave(text("Восстановление пароля AstraFit - Для восстановления вашего пароля на AstraFit перейдите, пожалуйста, по ссылке: Восстановление пароля")).click();
        $(byText("Восстановление пароля")).click();

        switchTo().window(1);
        enterNewPassword("1111");
        enterConfirmPassword("1111");
        pressSaveRecoverPassword();
        pressComeBackToSite();

// login with new password
        Configuration.timeout = 10000;
        switchTo().frame("af-wdgt-1");
        pressWidgetButton();

        switchTo().frame("af-sizer-frm-1");
        checkTextUnderPerametersRU();

        goToMyProfile();
        enterEmailForLogin(email);
        enterPasswordForLogin("1111");
        pressButtonSignIn();
        checkTextUnderPerametersRU();
        checkEmptyParamsField("Грудь");
        checkEmptyParamsField("Талия");
        checkEmptyParamsField("Бедра");
        checkEmptyParamsField("Обхват руки");
        checkEmptyParamsField("Рост");
        checkLoginUser();
        goToMyProfile();
        pressButtonSignOut();
       // deleteLetter();
    }

    @Test
        public void recoverPasswordSecondTime(){

        switchTo().frame("af-wdgt-1");
        pressWidgetButton();

        switchTo().frame("af-sizer-frm-1");

        goToMyProfile();
        pressForgotPassword();
        enterEmailForRecoverPassword(email);
        pressButtonSend();

        open("https://www.gmail.com/");
        Configuration.timeout = 20000;

        inbox.click();
        $$(".y6").get(0).shouldHave(text("Восстановление пароля AstraFit - Для восстановления вашего пароля на AstraFit перейдите, пожалуйста, по ссылке: Восстановление пароля")).click();
            $(byText("Восстановление пароля")).click();

        switchTo().window(1);
        enterNewPassword("2222");
        enterConfirmPassword("2222");
        pressSaveRecoverPassword();
        pressComeBackToSite();

// login with new password
        switchTo().frame("af-wdgt-1");
        pressWidgetButton();

        switchTo().frame("af-sizer-frm-1");
        checkTextUnderPerametersRU();

        goToMyProfile();
        enterEmailForLogin(email);
        enterPasswordForLogin("2222");
        pressButtonSignIn();
        checkTextUnderPerametersRU();
            checkLoginUser();
            goToMyProfile();
            pressButtonSignOut();
        //deleteLetter();
    }

  /*  @After
    public void tearDown ()throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot ()throws IOException {
        File screenshot = Screenshots.getScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }*/
}
