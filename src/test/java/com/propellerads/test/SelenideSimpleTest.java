package com.propellerads.test;

import com.propellerads.page.YandexMainPage;
import com.propellerads.util.Language;
import com.propellerads.util.Period;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

class SelenideSimpleTest {

    static Stream<Arguments> demoTest() {
        return Stream.of(
                Arguments.of(Period.DAY, Language.EN),
                Arguments.of(Period.DAY, Language.RU),
                Arguments.of(Period.WEEKS, Language.EN),
                Arguments.of(Period.MONTH, Language.RU)
        );
    }

    @EnumSource(value = Period.class, names = {"DAY"})
    @ParameterizedTest
    void demoTest(Period period) {
        open("http://ya.ru", YandexMainPage.class)
                .setSearchQuery("searchQuery")
                .search()
                .checkResultsCount(10)
                .openAdvancedSettings()
                .choosePeriod(period)
                .chooseLanguage(Language.EN)
                .submitAdvancedSettings()
                .checkResultsCount(10);
    }



}