package org.example;

import com.beust.jcommander.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Module2Task_aTest{

    WebDriver tester;

    @Test
    public void TestingPastebin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        tester = new ChromeDriver();
        tester.get("https://pastebin.com/");
        tester.manage().window().maximize();

        Module2Task_a M2 = new Module2Task_a(tester);
        M2.enterCode();
        JavascriptExecutor js2 = (JavascriptExecutor) tester;
        js2.executeScript("window.scrollBy(0,700)", "");
        M2.selectExpiry();
        M2.enterTitle();
        M2.createPaste();
    }


}