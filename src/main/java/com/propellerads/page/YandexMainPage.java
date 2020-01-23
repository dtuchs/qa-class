package com.propellerads.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexMainPage {

    private SelenideElement searchInput = $("input[name='text']");
    private SelenideElement searchButton = $("div.search2__button button");

    public YandexMainPage setSearchQuery(String query) {
        searchInput.setValue(query);
        return this;
    }

    public SearchResultPage search() {
        searchButton.click();
        return new SearchResultPage();
    }
}
