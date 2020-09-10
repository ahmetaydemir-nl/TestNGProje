package com.techproed.tests;

import com.techproed.pages.FhcTripLoginPage;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class HotelTest extends TestBase {
    @Test
    public void aramaTesti() {
        driver.get("http://fhctrip-qa.com/Account/LogOn?ReturnUrl=%2FAdmin%2FUserAdmin");
        FhcTripLoginPage loginPage = new FhcTripLoginPage(driver);
        loginPage.kullanici.sendKeys("manager2");
        loginPage.sifre.sendKeys("Man1ager2!");
        loginPage.login.click();
    }
}