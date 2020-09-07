package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class FileDownloadTest extends TestBase {

    @Test
    public void dosyaVarmi() {

        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        String kullaniciDosyaYolu = System.getProperty("user.dir");

        ///Users/ahmetaydemir/IdeaProjects/TestNGProje

        String pomXmlDosyaYolu = kullaniciDosyaYolu + "/pom.xml";

        boolean varMi = Files.exists(Paths.get(pomXmlDosyaYolu));
        System.out.println(varMi);

    }

    @Test
    public void dosyaUpload() {
        // bilgisayardan websayfasına doysa yükleme
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement dosyaSecmeButonu = driver.findElement(By.id("file-upload"));

        //yiklemek istedigimiz dosyanin path yolu eklenir
        dosyaSecmeButonu.sendKeys("/Users/ahmetaydemir/Downloads/logo.png");
        WebElement uploadButonu = driver.findElement(By.id("file-submit"));
        uploadButonu.click();


        //dosyasecmebutonu.sendkeys("Users/ahmetaydemir/Downloads/logo.png")

        WebElement fileUploadedYazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedYazisi.isDisplayed());

    }

    @Test
    public void dosyaDownload() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement anmsterdamLinki = driver.findElement(By.partialLinkText("Amsterdam.jpg"));
        anmsterdamLinki.click();
        Thread.sleep(7000);
        boolean varMi = Files.exists(Paths.get("/Users/ahmetaydemir/Downloads/Amsterdam.jpg"));
        Assert.assertTrue(varMi);
    }
}

