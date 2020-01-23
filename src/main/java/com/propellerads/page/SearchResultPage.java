package com.propellerads.page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.propellerads.util.Language;
import com.propellerads.util.Period;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage extends YandexMainPage {

    private ElementsCollection
            results = $$("li.serp-item"),
            periodButtons = $$("div[aria-label='Период'] label"),
            languageButtons = $$("div[aria-label='Язык найденных документов'] label");

    private SelenideElement
            enableSettingsButton = $("span.input__settings"),
            submitSettingsButton = $("button.advanced-search__submit-link");


    public SearchResultPage checkResultsCount(int expectedCount) {
        results.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(expectedCount));
        return this;
    }

    public SearchResultPage openAdvancedSettings() {
        enableSettingsButton.click();
        return this;
    }

    public SearchResultPage choosePeriod(Period period) {
        periodButtons.find(Condition.text(period.text)).click();
        return this;
    }

    public SearchResultPage chooseLanguage(Language language) {
        languageButtons.find(Condition.text(language.text)).click();
        return this;
    }

    public SearchResultPage submitAdvancedSettings() {
        submitSettingsButton.click();
        return this;
    }
}
