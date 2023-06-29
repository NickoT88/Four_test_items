package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Vacancies {

    private final WebDriver driver;
    private final By allCities = By.cssSelector("#input-831"); //локатор поля Все города

    private final By moscow = By.xpath("//*[@id='list-item-3087-0']"); //локатор элемента Москва

    private final By companies = By.xpath("//*[@id='input-3023'] "); //локатор поля Компании

    private final By tech = By.xpath("//*[@id='list-item-3045-2']"); //локатор поля Компании

    public Vacancies(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAllCities() {
        new WebDriverWait(driver, Duration.ofSeconds(3).toMillis())
                .until(ExpectedConditions.visibilityOfElementLocated(allCities));
        driver.findElement(allCities).click();
    }

    public void clickOnMoscow() {
        new WebDriverWait(driver, Duration.ofSeconds(3).toMillis())
                .until(ExpectedConditions.visibilityOfElementLocated(moscow));
        driver.findElement(moscow).click();
    }

    public void clickCompanies() {
        new WebDriverWait(driver, Duration.ofSeconds(3).toMillis())
                .until(ExpectedConditions.visibilityOfElementLocated(companies));
        driver.findElement(companies).click();
    }

    public void clickTech() {
        new WebDriverWait(driver, Duration.ofSeconds(3).toMillis())
                .until(ExpectedConditions.visibilityOfElementLocated(tech));
        driver.findElement(tech).click();
    }

    public void selectFields() {
        new WebDriverWait(driver, Duration.ofSeconds(3).toMillis())
                .until(ExpectedConditions.visibilityOfElementLocated(allCities));
        driver.findElement(allCities).click();
        driver.findElement(moscow).click();
        driver.findElement(companies).click();
        driver.findElement(tech).click();
    }


}
