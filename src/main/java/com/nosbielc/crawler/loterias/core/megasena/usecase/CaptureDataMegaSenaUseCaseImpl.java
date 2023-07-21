package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.megasena.exception.CaptureDataMegaSenaException;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CaptureDataMegaSenaUseCaseImpl implements CaptureDataMegaSenaUseCase {

    @Value("${loterica.results.megasena.url}")
    private String urlPrincipal;

    @Value("${loterica.results.megasena.params.id_button}")
    private String idButton;

    @Value("${loterica.results.megasena.params.id_table}")
    private String idTable;

    @Override
    public String execute() throws PortalAPIException {

        try {
            WebDriver driver = new ChromeDriver();

            driver.get(urlPrincipal);

            new WebDriverWait(driver, Duration.ofSeconds(15L)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15L));

            WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(idButton)));

            elemento.click();

            Set<String> handles = driver.getWindowHandles();

            Iterator<String> iterator = handles.iterator();
            String first = iterator.next();
            String second = iterator.next();

            driver.switchTo().window(second);

            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(35L));

            wait2.until(ExpectedConditions.elementToBeClickable(By.xpath(idTable)));

            var content = driver.getPageSource();

            driver.quit();

            return content;
        } catch (Exception ex) {
            throw new CaptureDataMegaSenaException("Error process Selenium.", ex);
        }

    }
}
