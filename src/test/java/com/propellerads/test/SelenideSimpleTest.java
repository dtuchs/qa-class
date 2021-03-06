package com.propellerads.test;

import com.codeborne.selenide.WebDriverRunner;
import com.propellerads.page.YandexMainPage;
import com.propellerads.util.Language;
import com.propellerads.util.Period;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

class SelenideSimpleTest {

    private YandexMainPage yandexMainPage;

    @BeforeEach
    void setup() {
        yandexMainPage = open("http://ya.ru/", YandexMainPage.class);
    }

    @AfterEach
    void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }


    @Test
    void firstTest() {
        yandexMainPage.getSearchComponent()
                .search("searchQuery")
                .checkResultsCount(10);
    }

    @Test
    void secondTest() {
        yandexMainPage.getSearchComponent()
                .search("searchQuery")
                .checkResultsCount(10)
                .openAdvancedSettings()
                .choosePeriod(Period.WEEKS)
                .chooseLanguage(Language.EN)
                .submitAdvancedSettings()
                .checkResultsCount(10);
    }
}