package form;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.RegistrationForm;
import page_object.SubmittingForm;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationFormTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    @DisplayName("Проверка полей регистрации студента")
    public void CheckStudentRegistrationFieldsOk() throws InterruptedException {
        RegistrationForm registrationForm = new RegistrationForm(driver);
        //открываем страницу
        registrationForm.openPage();
        //создаем тест-данные для ввода
        String firstName = RandomStringUtils.randomAlphabetic(6);
        String lastName = RandomStringUtils.randomAlphabetic(8);
        String email = RandomStringUtils.randomAlphanumeric(4) + "@gmail.com";
        String gender = registrationForm.getGender();
        String mobile = RandomStringUtils.randomNumeric(10);
        String month = registrationForm.selectMonth();
        int yearsOld = Integer.parseInt(RandomStringUtils.randomNumeric(2));
        String address = RandomStringUtils.randomAlphabetic(6) + " street";
        //заполняем форму регистрации
        registrationForm.inputData(firstName, lastName, email, gender, mobile, month, yearsOld, address);
        //создаем объект страницы подтвержденной формы
        SubmittingForm submittingForm = new SubmittingForm(driver);
        //достаем из нее данные
        String fullname_check = submittingForm.getFullNameText();
        String email_check = submittingForm.getEmailText();
        String gender_check = submittingForm.getGenderText();
        String mobile_check = submittingForm.getMobileText();
        String birthday_check = submittingForm.getBirthDayText();
        String subject_check = submittingForm.getSubjectText();
        String hobby_check = submittingForm.getHobbyText();
        String address_check = submittingForm.getAddressText();
        String location_check = submittingForm.getLocationText();
        assertAll("Введенные значения в форму регистрации должны быть равны значениям в подтвержденной форме",
                () -> assertEquals(firstName + " " + lastName, fullname_check),
                () -> assertEquals(email, email_check),
                () -> assertEquals(gender, gender_check),
                () -> assertEquals(mobile, mobile_check),
                () -> assertEquals("28 " + registrationForm.getMonth(month) + "," + registrationForm.setYear(yearsOld), birthday_check),
                () -> assertEquals("English", subject_check),
                () -> assertEquals("Sports", hobby_check),
                () -> assertEquals(address, address_check),
                () -> assertEquals("NCR Delhi", location_check)
        );
    }

}
