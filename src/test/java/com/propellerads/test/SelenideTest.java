package com.propellerads.test;

import com.codeborne.selenide.Configuration;
import com.propellerads.converter.MockConverter;
import com.propellerads.extension.BeforeAllExtension;
import com.propellerads.extension.BeforeEachExtension;
import com.propellerads.extension.MockResolver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.logging.LogManager;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;
import static com.propellerads.Color.ANSI_RESET;
import static com.propellerads.Color.ANSI_YELLOW;
import static java.lang.System.identityHashCode;
import static java.lang.System.setProperty;
import static java.lang.Thread.currentThread;

@ExtendWith({BeforeAllExtension.class, BeforeEachExtension.class})
class SelenideTest {

    static {
        Configuration.browser = "chrome";
        setProperty("webdriver.chrome.silentLogging", "true");
        setProperty("webdriver.chrome.silentOutput", "true");
        setProperty("webdriver.chrome.args", "--disable-logging");
        LogManager.getLogManager().reset();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("    ### @BeforeAll" + ANSI_YELLOW
                + " THREAD ID: " + currentThread().getId() + ANSI_RESET + "\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("    ### @AfterAll" + ANSI_YELLOW
                + " THREAD ID: " + currentThread().getId() + ANSI_RESET + "\n");
    }

    @BeforeEach
    void before() {
        System.out.println("            ### @BeforeEach" + ANSI_YELLOW
                + " THREAD ID: " + currentThread().getId() + ANSI_RESET
                + " for test instance ID: " + identityHashCode(this));
    }

    @AfterEach
    void after() {
        System.out.println("            ### @AfterEach" + ANSI_YELLOW
                + " THREAD ID: " + currentThread().getId() + ANSI_RESET
                + " for test instance ID: " + identityHashCode(this));
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "3"})
    @ExtendWith(MockResolver.class)
    void demoTest(@ConvertWith(MockConverter.class) String param, Integer id) {
        System.out.println("                    !!! TEST" + ANSI_YELLOW + " THREAD ID: " + currentThread().getId() + ANSI_RESET);
        System.out.println("                    !!! Test instance ID: " + identityHashCode(this));
        open("http://ya.ru");
        $("#text").setValue(param);
        $(".search2__button > button").click();
        $$("li.serp-item").shouldBe(sizeGreaterThanOrEqual(5));
    }

}