package org.selenide.examples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.TextReport;
import com.codeborne.selenide.logevents.SelenideLogger;
import domain.User;
import static org.junit.Assert.*;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class GanTest {
    @Rule
    public TextReport report = new TextReport();

    @Before
    public void configBefore(){
        Configuration.timeout = 120000;
        Configuration.pageLoadTimeout = 120000;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

    }

    @Test
    public void testGanUseCase(){
        open("https://moneygaming.qa.gameaccount.com/");
        User user = new User("Denys", "Polulyakh");
         String expectedErrorLabelText = "This field is required";
        String actualErrorLabelText = new HomePage()
                .proceedToSignUp()
                .fillUpTheForm(user)
                .clickJoinNowButton()
                .getActualErrorLabelText();
        assertEquals(expectedErrorLabelText,actualErrorLabelText);
    }
}
