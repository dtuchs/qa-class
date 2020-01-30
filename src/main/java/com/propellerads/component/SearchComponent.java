package com.propellerads.component;

import com.codeborne.selenide.SelenideElement;
import com.propellerads.page.SearchResultPage;

import static com.codeborne.selenide.Selenide.$;


public class SearchComponent {

    private SelenideElement
            self = $("[role='search']"),
            searchInput = self.$("input[name='text']"),
            searchButton = self.$("div.search2__button button");

    public SearchResultPage search(String query) {
        searchInput.setValue(query);
        searchButton.click();
        return new SearchResultPage();
    }
}
