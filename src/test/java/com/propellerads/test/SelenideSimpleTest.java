package com.propellerads.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;

import java.util.logging.LogManager;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;
import static com.propellerads.Color.ANSI_RESET;
import static com.propellerads.Color.ANSI_YELLOW;
import static java.lang.System.identityHashCode;
import static java.lang.System.setProperty;
import static java.lang.Thread.currentThread;

class SelenideSimpleTest {

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
        System.out.println("    \n### @AfterAll" + ANSI_YELLOW
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
    void demoTest(String param) {
        System.out.println("                    !!! TEST" + ANSI_YELLOW + " THREAD ID: " + currentThread().getId() + ANSI_RESET);
        System.out.println("                    !!! TEST instance ID: " + identityHashCode(this));
        open("http://ya.ru");
        $("#text").setValue(param);
        $(".search2__button > button").click();
        $$("li.serp-item").shouldBe(sizeGreaterThanOrEqual(5));
    }

}