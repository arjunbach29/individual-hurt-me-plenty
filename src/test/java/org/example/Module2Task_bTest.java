package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Module2Task_bTest {

    WebDriver driver;

    @Test
    public void TestingCloud() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        driver.manage().window().maximize();

        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.openCloudPage();
        calculatorPage.goToGoogleCloudPlatformPricingCalculatorPage(
                "Google Cloud Platform Pricing Calculator");
        calculatorPage.sendKeyInToNumberOfInstancesField("4");
        calculatorPage.selectSeriesOfMachine();
        calculatorPage.selectMachineType();
        calculatorPage.clickAddGpusCheckBox();
        calculatorPage.selectNumberOfGpus();
        calculatorPage.selectGpuType();
        calculatorPage.selectLocalSsd();
        calculatorPage.selectDataCenterLocation();
        calculatorPage.selectCommittedUsage();
        calculatorPage.pushAddToEstimate();
        calculatorPage.checkInformationInVmClassIsRegular();
        calculatorPage.pushAddToEstimate();
    }
}
