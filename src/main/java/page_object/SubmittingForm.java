package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmittingForm {

    private final WebDriver driver;
    private final By fullName_value = By.xpath("//td[2]"); //локатор поля firstName + lastName
    private final By email_value = By.xpath("//tr[2]/td[2]"); //локатор поля email
    private final By gender_value = By.xpath("//tr[3]/td[2]"); //локатор поля gender
    private final By mobile_value = By.xpath("//tr[4]/td[2]"); //локатор чекбокса mobile
    private final By birthDay_value = By.xpath("//tr[5]/td[2]"); //локатор поля day of birth
    private final By subjects_value = By.xpath("//tr[6]/td[2]"); //локатор поля subjects
    private final By hobby_value = By.xpath("//tr[7]/td[2]"); //локатор поля hobby
    private final By address_value = By.xpath("//tr[9]/td[2]"); //локатор поля address
    private final By location_value = By.xpath("//tr[10]/td[2]"); //локатор поля state + city

    public SubmittingForm(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получить текст fullName из формы")
    public String getFullNameText() {
        return driver.findElement(fullName_value).getText();
    }

    @Step("Получить текст email из формы")
    public String getEmailText() {
        return driver.findElement(email_value).getText();
    }

    @Step("Получить текст gender из формы")
    public String getGenderText() {
        return driver.findElement(gender_value).getText();
    }

    @Step("Получить текст mobile из формы")
    public String getMobileText() {
        return driver.findElement(mobile_value).getText();
    }

    @Step("Получить текст birthDay из формы")
    public String getBirthDayText() {
        return driver.findElement(birthDay_value).getText();
    }

    @Step("Получить текст subjects из формы")
    public String getSubjectText() {
        return driver.findElement(subjects_value).getText();
    }

    @Step("Получить текст hobby из формы")
    public String getHobbyText() {
        return driver.findElement(hobby_value).getText();
    }

    @Step("Получить текст address из формы")
    public String getAddressText() {
        return driver.findElement(address_value).getText();
    }

    @Step("Получить текст location из формы")
    public String getLocationText() {
        return driver.findElement(location_value).getText();
    }
}
