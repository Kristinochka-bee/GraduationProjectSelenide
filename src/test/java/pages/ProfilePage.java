package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;



import wait.Wait;

public class ProfilePage extends HomePage{
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='profile']")
    protected WebElement profileForm;

    @FindBy(xpath = "//div[@class='filter-option-inner-inner']")
    protected WebElement selectRoleButton;

    @FindBy(xpath = "//a[@id='bs-select-1-0']")
    protected WebElement selectedTeacher;

    @FindBy(xpath = "//a[@id='bs-select-1-1']")
    protected WebElement selectedStudent;

    @FindBy(xpath = "//input[@name='full_name']")
    protected WebElement nameInput;

    @FindBy(xpath = "//input[@name='static_email']")
    protected WebElement emailInput;

    @FindBy(xpath = "//div//textarea[@name='About']")
    protected WebElement aboutYourselfInput;

    @FindBy(xpath = "//input[@name='External Profile URL']")
    protected WebElement externalProfileInput;

    @FindBy(xpath = "//input[@name='Major']")
    protected WebElement majorInput;

    @FindBy(xpath = "//a[@id='sw-update-profile-btn']")
    protected WebElement updateProfileButton;

    @FindBy(xpath = "//div[@class='change-password']")
    protected WebElement changePasswordForm;

    @FindBy(xpath = "//input[@placeholder='Old password']")
    protected WebElement oldPasswordInput;

    @FindBy(xpath = "//input[@placeholder='New password']")
    protected WebElement newPasswordInput;

    @FindBy(xpath = "//a[@id='sw-change-password-btn']")
    protected WebElement changePasswordButton;

    @FindBy(xpath = "//i[@class='fa fa-fw fa-check d-none']")
    protected WebElement successfulUpdateProfileMsg;

    String successMsg = "//i[@class='fa fa-fw fa-check d-none']";


    public void waitForLoading(){
        wait = new Wait(driver);
        wait.forVisibility(profileForm);
        wait.forVisibility(selectRoleButton);
        wait.forVisibility(nameInput);
        wait.forVisibility(emailInput);
        wait.forVisibility(aboutYourselfInput);
        wait.forVisibility(userAvatarButton);
        wait.forVisibility(logoButton);
    }

    public void waitSuccessMsgForLoading() {
        wait = new Wait(driver);
        wait.forVisibility(successfulUpdateProfileMsg);
    }

    public void selectTeacherRole(){
        selectRoleButton.click();
        click(selectedTeacher);
    }

    public void selectStudentRole(){
        selectRoleButton.click();
        click(selectedStudent);
    }

    public void clickOnSelectedTeacher(){
        selectedTeacher.click();
    }

    public void clickOnUpdateProfileButton(){
        scrollToElement(app.driver, updateProfileButton);
        try {
            updateProfileButton.click();
        } catch ( ElementNotInteractableException e){
            e.printStackTrace();
        }
    }

    public void scrollPageToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, window.innerHeight)");
    }

    public void clickOnChangePasswordButton(){
        changePasswordButton.click();
    }


    public void fillName(String text){
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(text);
    }

    public void fillEmail(String text){
        emailInput.click();
        aboutYourselfInput.clear();
        emailInput.sendKeys(text);
    }

    public void fillAboutYourself(String text){
        aboutYourselfInput.click();
        aboutYourselfInput.clear();
        aboutYourselfInput.sendKeys(text);
    }

    public void fillExternalProfile(String text){
        scrollToElement(app.driver, externalProfileInput);
        try {
            externalProfileInput.click();
        } catch ( ElementNotInteractableException e){
            e.printStackTrace();
        }
        externalProfileInput.clear();
        externalProfileInput.sendKeys(text);
    }

    public void fillMajor(String text){
        majorInput.click();
        majorInput.clear();
        majorInput.sendKeys(text);
    }

    public void fillOldPassword(String text) {
        oldPasswordInput.click();
        oldPasswordInput.clear();
        oldPasswordInput.sendKeys(text);
    }

    public void fillNewPassword(String text) {
        newPasswordInput.click();
        newPasswordInput.clear();
        newPasswordInput.sendKeys(text);
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth',block: 'center'});", element);
    }

    public boolean isSuccessfulButtonPresent() {
        try {
            driver.findElement(By.xpath(successMsg));
            return true;
        } catch (NoSuchElementException exception) {
            exception.printStackTrace();
            return false;
        }
    }

}