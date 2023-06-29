package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

public class RegistrationForm {

    private final WebDriver driver;
    private final By firstName = By.xpath("//input[@id='firstName']"); //локатор поля firstName
    private final By lastName = By.xpath("//input[@id='lastName']"); //локатор поля lastName
    private final By emailAddress = By.xpath("//input[@id='userEmail']"); //локатор поля email
    private final By male = By.xpath("//label[contains(.,'Male')]"); //локатор male
    private final By female = By.xpath("//label[contains(.,'Female')]"); //локатор female
    private final By other = By.xpath("//label[contains(.,'Other')]"); //локатор other
    private final By mobile = By.xpath("//input[@id='userNumber']"); //локатор поля mobile
    private final By birthDay = By.xpath("//input[@id='dateOfBirthInput']"); //локатор поля day of birth
    private final By subjects = By.xpath("//*[@id='subjectsInput']"); //локатор поля subjects
    private final By selectSubject = By.xpath("//div[@id='react-select-2-option-0']"); //локатор поля subjects
    private final By sports = By.xpath("//label[contains(.,'Sports')]"); //локатор sports
    private final By reading = By.xpath("//label[contains(.,'Reading')]"); //локатор reading
    private final By music = By.xpath("//label[contains(.,'Music')]"); //локатор music
    private final By currentAddress = By.xpath("//textarea[@id='currentAddress']"); //локатор поля day of currentAddress
    private final By selectState = By.xpath("//*[@id='state']");//локатор списка штатов
    private final By state = By.xpath("//div[@id='react-select-3-option-0']"); //локатор штата NCR
    private final By selectCity = By.xpath("//*[@id='city']"); //локатор списка городов
    private final By city = By.xpath("//div[@id='react-select-4-option-0']"); //локатор города Delhi
    private final By submit = By.xpath("//button[@id='submit']"); //локатор кнопки Submit
    private final By yearSelect = By.xpath("//select[@class='react-datepicker__year-select']"); //локатор поля год в выборе даты рождения
    private final By monthSelect = By.xpath("//select[@class='react-datepicker__month-select']"); //локатор поля месяц в выборе даты рождения
    private final By daySelect = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--028']");
    private final By thanksForSub = By.xpath(("//div[@id='example-modal-sizes-title-lg']")); //локатор надписи Thanks for submitting the form

    public RegistrationForm(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://demoqa.com/automation-practice-form");
    }


    @Step("Рандомный выбор гендера")
    public String getGender() {
        String[] genders = {"Male", "Female", "Other"};
        Random rand = new Random();
        // Получаем случайный индекс из массива genders
        int randomIndex = rand.nextInt(genders.length);
        return genders[randomIndex];
    }


    @Step("Выбор локатора для гендера")
    public By getLocatorGender(String gender) {
        Map<String, By> genderLocators = new HashMap<>();
        genderLocators.put("Male", male);
        genderLocators.put("Female", female);
        genderLocators.put("Other", other);
        return genderLocators.get(gender);
    }


    @Step("Выбрать в качестве предмета English")
    public void chooseSubjectEnglish() {
        WebElement selectSub = driver.findElement(subjects);
        selectSub.click();
        selectSub.sendKeys("English");
        driver.findElement(selectSubject).click();
    }


    @Step("Метод от текущего года отнимает заданное кол-во лет и возвращает полученное значение типа String")
    public String setYear(int minusYears) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -minusYears);
        Date newDate = calendar.getTime();
        return dateFormat.format(newDate);
    }


    @Step("Выбирает произвольный месяц")
    public String selectMonth() {
        String[] months = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        Random random = new Random();
        int index = random.nextInt(12);
        return months[index];
    }


    @Step("Возвращает месяц в зависимости от полученного значения (для проверки)")
    public String getMonth(String num) {
        int index = Integer.parseInt(num);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return months[index];
    }


    @Step("Вводим дату рождения")
    public void enterBirthDate(String month, String year) {
        new WebDriverWait(driver, Duration.ofSeconds(5).toMillis())
                .until(ExpectedConditions.elementToBeClickable(birthDay));
        WebElement dateFieldSelection = driver.findElement(birthDay);
        dateFieldSelection.click();
        //устанавливаем год
        WebElement yearWeb = driver.findElement(yearSelect);
        Select select_year = new Select(yearWeb);
        select_year.selectByValue(year);
        //устанавливаем месяц
        WebElement monthWeb = driver.findElement(monthSelect);
        Select select_month = new Select(monthWeb);
        select_month.selectByValue(month);
        //выбираем 28 число
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(daySelect));
        driver.findElement(daySelect).click();
        driver.findElement(birthDay).click();
        dateFieldSelection.sendKeys(Keys.ENTER);
    }

    @Step("Вводим все данные для регистрации")
    public void inputData(String fName, String lName, String email, String gender, String tel, String month, int minusYears, String address) throws InterruptedException {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(emailAddress));
        driver.findElement(emailAddress).sendKeys(email);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(getLocatorGender(gender)));
        driver.findElement(getLocatorGender(gender)).click();
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(mobile));
        driver.findElement(mobile).sendKeys(tel);
        Thread.sleep(1500);
        enterBirthDate(month, setYear(minusYears));
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(subjects));
        chooseSubjectEnglish();
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(sports));
        driver.findElement(sports).click();
        driver.findElement(currentAddress).sendKeys(address);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(selectState));
        driver.findElement(selectState).click();
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(state));
        driver.findElement(state).click();
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(selectCity));
        driver.findElement(selectCity).click();
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(city));
        driver.findElement(city).click();
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();

    }

    @Step("Вводим данные для регистрации без email")
    public void inputDataForNegativeCheckWithoutEmail(String fName, String lName, String gender, String tel) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(getLocatorGender(gender)));
        driver.findElement(getLocatorGender(gender)).click();
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(mobile));
        driver.findElement(mobile).sendKeys(tel);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
    }

    @Step("Вводим данные для регистрации, используя email")
    public void inputDataForNegativeCheckWithEmail(String fName, String lName, String email, String gender, String tel) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(emailAddress));
        driver.findElement(emailAddress).sendKeys(email);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(getLocatorGender(gender)));
        driver.findElement(getLocatorGender(gender)).click();
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(mobile));
        driver.findElement(mobile).sendKeys(tel);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
    }

    @Step("Вводим данные для регистрации без email и гендера")
    public void inputDataForNegativeCheckWithoutEmaiAndGender(String fName, String lName, String tel) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(mobile));
        driver.findElement(mobile).sendKeys(tel);
        new WebDriverWait(driver, Duration.ofSeconds(2).toMillis())
                .until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
    }

    @Step("Возвращает логическое значение в зависимости виден ли итоговый баннер с данными или нет")
    public boolean isVisibleTitle() {
        // Поиск элементов, соответствующих заданному локатору
        List<WebElement> elements = driver.findElements(thanksForSub);
        // Если список пустой, значит элемент не найден на странице
        return elements.isEmpty();
    }
}
