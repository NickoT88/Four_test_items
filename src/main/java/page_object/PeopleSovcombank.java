package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PeopleSovcombank {

    private final WebDriver driver;
    private final By vacancy = By.xpath(".//span[(@class ='v-btn__content' and text()='Вакансии')]"); //локатор кнопки Вакансии

    public PeopleSovcombank(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://people.sovcombank.ru/");
    }

    public void clickOnVacancyButton() {
        //WebElement element = driver.findElement(vacancy);
        new WebDriverWait(driver, Duration.ofSeconds(5).toMillis())
                .until(ExpectedConditions.elementToBeClickable(vacancy));
        driver.findElement(vacancy).click();
    }
}
