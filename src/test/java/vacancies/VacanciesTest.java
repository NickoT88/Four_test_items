package vacancies;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.PeopleSovcombank;
import page_object.Vacancies;

import java.util.concurrent.TimeUnit;

public class VacanciesTest {

    private WebDriver driver;
    private PeopleSovcombank peopleSovcombank;
    private Vacancies vacancies;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Нажимаем на кнопку Вакансии")
    public void clickVacanciesButton() {
        peopleSovcombank = new PeopleSovcombank(driver);
        peopleSovcombank.openPage();
        peopleSovcombank.clickOnVacancyButton();
        vacancies = new Vacancies(driver);
        vacancies.selectFields();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
