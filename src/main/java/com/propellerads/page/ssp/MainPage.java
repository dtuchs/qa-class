package com.propellerads.page.ssp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement createCampaignButton = $("#adv-header-create-campaign-button");
    private SelenideElement tableBody = $("div.rt-tbody");

    public NewCampaignPage createCampaign() {
        createCampaignButton.click();
        return new NewCampaignPage();
    }

    public MainPage checkTableContainsByName(String expectedName) {
        findRowByName(expectedName).shouldBe(Condition.visible);
        return this;
    }

    public NewCampaignPage openCampaignByName(String expectedName) {
        SelenideElement row = findRowByName(expectedName);
        ElementsCollection columns = row.$$(".rt-td");
        columns.find(Condition.text(expectedName)).$("a").click();
        return new NewCampaignPage();
    }

    private SelenideElement findRowByName(String expectedName) {
        ElementsCollection rows = tableBody.$$(".rt-tr-group");
        return rows.find(Condition.text(expectedName));
    }
}
