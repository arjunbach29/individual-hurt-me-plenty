package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage   {
    WebDriver driver;
    public CalculatorPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

     By devSiteSearch = By.className("devsite-search-form");
     By googleSearch = By.xpath("//input[@class='devsite-search-field devsite-search-query']");
     By switchToCalculator = By.xpath("//div[contains(text(),'Pricing calculator')]");
    @FindBy(xpath ="/html[1]/body[1]/md-content[1]/md-card[1]/div[1]/md-card-content[1]/div[2]/div[1]/md-card[1]/md-card-content[1]/div[1]/div[1]/form[1]/div[1]/div[1]/md-input-container[1]/input[1]")
    WebElement instancesField;
    @FindBy(xpath="//iframe[contains(@name,'goog_')]")
    WebElement newFirstFrame;
    @FindBy(xpath="//md-select[@name='series']/parent::md-input-container")
    WebElement seriesOfMachine;

    @FindBy(xpath="//md-option[@id='select_option_212']")
    WebElement seriesOfMachineModel;
    @FindBy(xpath="//label[text()='Machine type']/parent::md-input-container")
    WebElement machineTypeDropBox;
    @FindBy(xpath="//div[normalize-space()='n1-standard-8 (vCPUs: 8, RAM: 30GB)']")
    WebElement machineType;
    @FindBy(xpath="//md-checkbox[@aria-label='Add GPUs']")
    WebElement gpusCheckBox;
    @FindBy(xpath="//md-select[@placeholder='GPU type']")
    WebElement GpuTypeDropBox;

    @FindBy(xpath="//md-select[@placeholder='Number of GPUs']")
    WebElement numberOfGpusDropBox;
    @FindBy(xpath ="//md-option[@id='select_option_497']")
    WebElement numberOfGpus;
    @FindBy(xpath="//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement gpusType;

    @FindBy(xpath="//md-select[@placeholder='Local SSD']")
    WebElement localSsd;
    @FindBy(xpath="//div[normalize-space()='2x375 GB']")
    WebElement localSsdModel;

    @FindBy(xpath="//md-select[@placeholder='Datacenter location']")
    WebElement DataCenterLocationDropBox;
    @FindBy(xpath="//md-option[@id='select_option_253']//div[@class='md-text ng-binding'][normalize-space()='Frankfurt (europe-west3)']")
    WebElement DataCenterLocation;

    @FindBy(xpath="//md-select[@placeholder='Committed usage']")
    WebElement committedUsage;
    @FindBy(xpath="//md-option[@id='select_option_134']")
    WebElement oneYearUsage;

    @FindBy(xpath="//form[@name='ComputeEngineForm']//button[@type='button'][normalize-space()='Add to Estimate']")
    WebElement addToEstimateButton;
    @FindBy(xpath="//div[normalize-space()='Provisioning model: Regular']")
    WebElement Vm_Class_Data;
    @FindBy(xpath="//div[normalize-space()='Region: Frankfurt']")
    WebElement location;

    @FindBy(xpath="//div[normalize-space()='Commitment term: 1 Year']")
    WebElement commitedTime;

    @FindBy(xpath="//div[contains (text(),'Instance type: n1-standard-8')]")
    WebElement instanceData;

    @FindBy(xpath="//div[contains (text(),'Local SSD: 2x375 GiB')]")
    WebElement ssdData;

    @FindBy(xpath="//b[contains(text(),'Total Estimated Cost:')]")
    WebElement amount;


    public void goToGoogleCloudPlatformPricingCalculatorPage(String keyForCalculatorPageOpening) throws InterruptedException {
        driver.findElement(devSiteSearch).click();
        WebElement textForGoogleSearch = driver.findElement(googleSearch);
        textForGoogleSearch.click();
        textForGoogleSearch.sendKeys(keyForCalculatorPageOpening);
        textForGoogleSearch.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        WebElement searchResult = (new WebDriverWait(driver,Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "//a[contains(text(),'Pricing')]"))));
        searchResult.click();
        searchResult.findElement(switchToCalculator).click();
        Thread.sleep(2000);

    }

    public void sendKeyInToNumberOfInstancesField(String keyForNumberOfInstances) {

        driver.switchTo().frame(newFirstFrame);
        driver.switchTo().frame("myFrame");
        instancesField.sendKeys(keyForNumberOfInstances);
    }

    public void selectSeriesOfMachine() throws InterruptedException {
        seriesOfMachine.click();
        Thread.sleep(1000);
        seriesOfMachineModel.click();
    }

    public void selectMachineType() throws InterruptedException {
        machineTypeDropBox.click();
        Thread.sleep(1000);
        machineType.click();
    }

    public void clickAddGpusCheckBox() {
        gpusCheckBox.click();
    }

    public void selectGpuType() throws InterruptedException {
        GpuTypeDropBox.click();
        Thread.sleep(1000);
        gpusType.click();
    }

    public void selectNumberOfGpus() throws InterruptedException {
        numberOfGpusDropBox.click();
        Thread.sleep(500);
        numberOfGpus.click();
    }

    public void selectLocalSsd() throws InterruptedException {
       localSsd.click();
       Thread.sleep(1000);
       localSsdModel.click();
    }

    public void selectDataCenterLocation() throws InterruptedException {
        DataCenterLocationDropBox.click();
        Thread.sleep(1000);
        DataCenterLocation.click();
    }

    public void selectCommittedUsage() throws InterruptedException {
        committedUsage.click();
        Thread.sleep(1000);
        oneYearUsage.click();
    }

    public void pushAddToEstimate() {
        addToEstimateButton.click();
    }


    public WebElement Get_Vm_Class_Data()
    {
        WebElement vmData = Vm_Class_Data;
        return vmData;
    }

    public WebElement Get_Location()
    {
        WebElement loc=location;
        return loc;
    }

    public WebElement Get_Commitment(){
        WebElement time=commitedTime;
        return time;
    }


    public WebElement Get_Instance_Type(){
        WebElement instance=instanceData;
        return instance;
    }


    public WebElement Get_Ssd_Data()
    {
        WebElement ssd=ssdData;
        return ssd;
    }

    public WebElement Get_Cost(){
        WebElement price=amount;
        return price;
    }
}

