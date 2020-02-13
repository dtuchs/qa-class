package com.propellerads.page.ssp;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.propellerads.domain.Campaign;

import static com.codeborne.selenide.Selenide.$;

public class NewCampaignPage {

    private SelenideElement campaignName = $("#adv-campaign-name");
    private SelenideElement targetUrl = $("#adv-campaign-target-url");
    private SelenideElement country = $("#adv-campaign-targeting-country-0");
    private SelenideElement rate = $("#adv-campaign-amount-rate-0");
    private SelenideElement confirmCheckBox = $(".confirm-checkbox__check");
    private SelenideElement saveAsDraftButton = $("#adv-campaign-save-draft");

    public MainPage fillOnlyRequiredFields(Campaign campaign) {
        campaignName.setValue(campaign.campaignName);
        targetUrl.setValue(campaign.targetUrl);
        country.click();
        country.$("#react-select-2-input").setValue(campaign.country).pressEnter();
        rate.setValue(campaign.rate);
        confirmCheckBox.click();
        saveAsDraftButton.click();
        return new MainPage();
    }

    public NewCampaignPage checkRequiredFields(Campaign campaign) {
        campaignName.shouldHave(Condition.value(campaign.campaignName));
        targetUrl.shouldHave(Condition.value(campaign.targetUrl));
        country.shouldHave(Condition.text(campaign.country));
        rate.shouldHave(Condition.value(campaign.rate));
        return this;
    }
}
