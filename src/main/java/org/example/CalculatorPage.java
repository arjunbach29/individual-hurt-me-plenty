package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage extends CloudHomePage {
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    private By devSiteSearch = By.className("devsite-search-form");
    private By googleSearch = By.xpath("//input[@class='devsite-search-field devsite-search-query']");
    private By switchToCalculator = By.xpath(
            "//b[text()='Google Cloud Pricing Calculator']/parent::a");
    private By newFirstFrame = By.xpath("//iframe[contains(@name,'goog_')]");
    private By instancesField =
            By.xpath("//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']");
    private By seriesOfMachine = By.xpath("//md-select[@name='series']/parent::md-input-container");
    private By seriesOfMachineModel = By.xpath("//md-option[@value='n1']");
    private By machineType = By.xpath("//label[text()='Machine type']/parent::md-input-container");
    private By computeEngine = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
    private By gpusCheckBox = By.xpath("//md-checkbox[@aria-label='Add GPUs']");
    private By numberOfGpus = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private By numberOfGpusModel = By.cssSelector("md-option[value='1'][class='ng-scope md-ink-ripple'][ng-disabled]");
    private By gpuType = By.xpath("//md-select[@placeholder='GPU type']");
    private By gpuTypeModel = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private By localSsd = By.xpath("//md-select[@placeholder='Local SSD']");
    private By localSsdModel = By.cssSelector("md-option[value='2'][ng-repeat*='supportedSsd']");
    private By dataCenterLocation = By.xpath("//md-select[@placeholder='Datacenter location']");
    private By dataCenterLocationInFrankfurt = By.cssSelector("md-select-menu[class='md-overflow']" +
            " md-option[value='europe-west3'][ng-repeat*='fullRegionList']");
    private By committedUsage = By.xpath("//md-select[@placeholder='Committed usage']");
    private By oneYearUsage = By.cssSelector("div[class='md-select-menu-container md-active md-clickable']" +
            " md-option[value='1'][class='md-ink-ripple']");
    private By addToEstimateButton = By.xpath("//button[@aria-label='Add to Estimate']");
    private By informationInVmClassIsRegular = By.xpath("//div[contains (text(),'VM class: regular')]");
    private By InformationInInstanceTypeIncludeN1Standard8 =
            By.xpath("//div[contains (text(),'Instance type: n1-standard-8')]");
    private By regionIsFrankfurt = By.xpath("//div[contains (text(),'Region: Frankfurt')]");
    private By localSsdSpace2x375Gib = By.xpath("//div[contains (text(),'Total available local SSD space 2x375 GiB')]");
    private By commitmentTermOneYear = By.xpath("//div[contains (text(),'Commitment term: 1 Year')]");


    public void openCloudPage(){
        driver.get("https://cloud.google.com/");
    }

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
        searchResult.findElement(By.xpath("//div[contains(text(),'Pricing calculator')]")).click();
        Thread.sleep(2000);

    }

    public void sendKeyInToNumberOfInstancesField(String keyForNumberOfInstances) {
        WebElement element = driver.findElement(newFirstFrame);
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        WebElement numberOfInstancesField = driver.findElement(instancesField);
        numberOfInstancesField.sendKeys(keyForNumberOfInstances);
    }

    public void selectSeriesOfMachine() {
        driver.findElement(seriesOfMachine).click();
        driver.findElement(seriesOfMachineModel).click();
    }

    public void selectMachineType() {
        driver.findElement(machineType).click();
        driver.findElement(computeEngine).click();
    }

    public void clickAddGpusCheckBox() {
        driver.findElement(gpusCheckBox).click();
    }

    public void selectNumberOfGpus() {
        driver.findElement(numberOfGpus).click();
        driver.findElement(numberOfGpusModel).click();
    }

    public void selectGpuType() {
        driver.findElement(gpuType).click();
        driver.findElement(gpuTypeModel).click();
    }

    public void selectLocalSsd() {
        driver.findElement(localSsd).click();
        driver.findElement(localSsdModel).click();
    }

    public void selectDataCenterLocation() {
        driver.findElement(dataCenterLocation).click();
        driver.findElement(dataCenterLocationInFrankfurt).click();
    }

    public void selectCommittedUsage() {
        driver.findElement(committedUsage).click();
        driver.findElement(oneYearUsage).click();
    }

    public void pushAddToEstimate() {
        driver.findElement(addToEstimateButton).click();
    }

    public void checkInformationInVmClassIsRegular(){
        driver.findElement(informationInVmClassIsRegular);
    }

    public void checkInformationInInstanceTypeIncludeN1Standard8(){
        driver.findElement(InformationInInstanceTypeIncludeN1Standard8);
    }

    public void checkRegionIsFrankfurt(){
        driver.findElement(regionIsFrankfurt);
    }

    public void checkLocalSsdSpace2x375Gib(){
        driver.findElement(localSsdSpace2x375Gib);
    }

    public void checkCommitmentTermOneYear(){
        driver.findElement(commitmentTermOneYear);
    }
}

