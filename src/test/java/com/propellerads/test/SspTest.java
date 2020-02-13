package com.propellerads.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.propellerads.domain.Campaign;
import com.propellerads.page.ssp.LoginPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SspTest {

    static {
        Configuration.timeout = 8000;
    }

    private static Campaign campaign;

    @BeforeAll
    static void initData() {
        campaign = new Campaign();
        campaign.campaignName = "TEST_CAMPAIGN";
        campaign.targetUrl = "http://www.domain.com/in.php?zoneid={zoneid}";
        campaign.country = "United States";
        campaign.rate = "1";
    }

    @Test
    void createCPMOnClickCampaignTest() {
        Selenide.open("http://ssp-stg10.rtty.in/#/app/auth", LoginPage.class)
                .login("random-08254af2@example.com", "123456")
                .createCampaign()
                .fillOnlyRequiredFields(campaign)
                .checkTableContainsByName(campaign.campaignName)
                .openCampaignByName(campaign.campaignName)
                .checkRequiredFields(campaign);
    }
}
