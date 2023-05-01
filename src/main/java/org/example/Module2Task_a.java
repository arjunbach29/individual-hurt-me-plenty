package org.example;

import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Module2Task_a {

    WebDriver tester;

    By createText = By.id("postform-text");

    By paste_expire = By.id("select2-postform-expiration-container");

    By expire = By.xpath("//span[@class= 'select2-results']/ul/li[3]");


    By pasteTitle = By.xpath("//input[@id='postform-name']");

    public Module2Task_a(WebDriver tester){
        this.tester = tester;
    }

    public void enterCode() throws InterruptedException {
        tester.findElement(createText).sendKeys("Hello from WebDriver");
        Thread.sleep(2000);
    }


    public void selectExpiry() throws InterruptedException {


        tester.findElement(paste_expire).click();
        Thread.sleep(2000);

        tester.findElement(expire).click();
        Thread.sleep(2000);

    }

    public void enterTitle() throws InterruptedException {

        tester.findElement(pasteTitle).sendKeys("helloweb");
        Thread.sleep(2000);

    }

    public void createPaste() throws InterruptedException {

        tester.findElement(By.xpath("//button[contains(text(),'Create New Paste')]")).click();
        Thread.sleep(2000);

    }



}
