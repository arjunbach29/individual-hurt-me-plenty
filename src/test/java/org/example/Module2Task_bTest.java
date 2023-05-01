package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Module2Task_bTest {

    WebDriver driver;

    CalculatorPage obj;
    String VM_Of_Class;
    String region;
    String S_S_D;
    String No_of_Instance;
    String Time_Taken;
    String Cost_of_USD;

    @BeforeClass
    @Parameters({"browser", "Url"})
    public void openBrowser(String browser, String Url) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            obj = new CalculatorPage(driver);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            obj = new CalculatorPage(driver);
        }
        driver.get(Url);
    }

    @Test
    public void TestingCloud() throws InterruptedException {

        driver.manage().window().maximize();
        obj.goToGoogleCloudPlatformPricingCalculatorPage("Google Cloud Platform Pricing Calculator");
        obj.sendKeyInToNumberOfInstancesField("4");
        obj.selectSeriesOfMachine();
        Thread.sleep(5000);
        obj.selectMachineType();
        Thread.sleep(5000);
        obj.clickAddGpusCheckBox();
        obj.selectGpuType();
        obj.selectNumberOfGpus();
        obj.selectLocalSsd();
        obj.selectDataCenterLocation();
        obj.selectCommittedUsage();
        obj.pushAddToEstimate();
        //Data Store from Object

        VM_Of_Class = obj.Get_Vm_Class_Data().getText();
        region = obj.Get_Location().getText();
        S_S_D = obj.Get_Ssd_Data().getText();
        No_of_Instance = obj.Get_Instance_Type().getText();
        Time_Taken = obj.Get_Commitment().getText();
        Cost_of_USD = obj.Get_Cost().getText();
    }

    @Test
    public void VerifyingData() {
        Assert.assertEquals(VM_Of_Class, "Provisioning model: Regular");
        Assert.assertEquals(region, "Region: Frankfurt");
        Assert.assertEquals(S_S_D, "Local SSD: 2x375 GiB\n" + "Committed Use Discount applied");
        Assert.assertEquals(No_of_Instance, "Instance type: n1-standard-8\n" + "Committed Use Discount applied");
        Assert.assertEquals(Time_Taken, "Commitment term: 1 Year");
        Assert.assertEquals(Cost_of_USD, "Total Estimated Cost: USD 1,081.20 per 1 month");
    }

}