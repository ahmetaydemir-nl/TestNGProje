package com.techproed.smoketests;

import com.techproed.pages.FacebookLoginPage;
import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FhcTripLoginTest extends TestBase {
    @Test
    public void test(){
        driver.get(ConfigurationReader.getProperty("fhc_login"));
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
        loginPage.kullanici.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.sifre.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.login.click();


    }
}
