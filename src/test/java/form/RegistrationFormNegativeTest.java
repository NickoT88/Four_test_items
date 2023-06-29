package form;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.RegistrationForm;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RegistrationFormNegativeTest {
    private WebDriver driver;

    public static Stream<Arguments> testData() {
        return Stream.of(
                arguments("", RandomStringUtils.randomAlphabetic(8), "Male", RandomStringUtils.randomNumeric(10)), //без firstName
                arguments(RandomStringUtils.randomAlphabetic(8), "", "Male", RandomStringUtils.randomNumeric(10)), //без lastName
                arguments(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(10), "Male", RandomStringUtils.randomNumeric(9)), //номер телефона 9 цифр (требуется 10)
                arguments(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(10), "Male", RandomStringUtils.randomAlphabetic(10)) //номер телефона 10 букв


        );
    }

    public static Stream<Arguments> testDataForEmail() {
        return Stream.of(
                arguments(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(10), "@gmail.com", "Male", RandomStringUtils.randomNumeric(10)), //без имени почты
                arguments(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphanumeric(6) + "gmail.com", "Male", RandomStringUtils.randomNumeric(10)), //email без @
                arguments(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphanumeric(6) + "@gmailcom", "Male", RandomStringUtils.randomNumeric(10)), //email без .
                arguments(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(10), "кириллица@.gmail.com", "Male", RandomStringUtils.randomNumeric(10)) //email на кириллице


        );
    }

    public static Stream<Arguments> testDataWithoutGender() {
        return Stream.of(
                arguments(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomNumeric(10))
        );
    }

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

    @ParameterizedTest(name = "Тестовые данные: {0},{1},{2},{3}")
    @MethodSource("testData")
    @DisplayName("Негативные проверки обязательных полей регистрации студента")
    public void checkNegativeDataNoVisibleSubForm(String firstName, String lastName, String gender, String mobile) {
        RegistrationForm registrationForm = new RegistrationForm(driver);
        //открываем страницу
        registrationForm.openPage();
        //заполняем форму регистрации
        registrationForm.inputDataForNegativeCheckWithoutEmail(firstName, lastName, gender, mobile);
        assertTrue(registrationForm.isVisibleTitle());
    }

    @ParameterizedTest(name = "Тестовые данные: {0},{1},{2},{3},{4}")
    @MethodSource("testDataForEmail")
    @DisplayName("Негативные проверки обязательных полей регистрации студента")
    public void checkEmailWithNegativeDataNoVisibleSubForm(String firstName, String lastName, String email, String gender, String mobile) {
        RegistrationForm registrationForm = new RegistrationForm(driver);
        //открываем страницу
        registrationForm.openPage();
        //заполняем форму регистрации
        registrationForm.inputDataForNegativeCheckWithEmail(firstName, lastName, email, gender, mobile);
        assertTrue(registrationForm.isVisibleTitle());
    }

    @ParameterizedTest(name = "Тестовые данные: {0},{1},{2},{3},{4}")
    @MethodSource("testDataWithoutGender")
    @DisplayName("Негативные проверки обязательных полей регистрации студента")
    public void checkInputDataWithoutGenderNoVisibleSubForm(String firstName, String lastName, String mobile) {
        RegistrationForm registrationForm = new RegistrationForm(driver);
        //открываем страницу
        registrationForm.openPage();
        //заполняем форму регистрации
        registrationForm.inputDataForNegativeCheckWithoutEmaiAndGender(firstName, lastName, mobile);
        assertTrue(registrationForm.isVisibleTitle());
    }


}
