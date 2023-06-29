package cleanuri;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class CleanUriTest {

    @ParameterizedTest(name = "Тестовые данные: {0}")
    @CsvFileSource(resources = "/test_url.csv")
    @DisplayName("Передаем url для изменения - 200 Ok")
    public void testPositiveShortenUrlOk(String urlToShorten) {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("url", urlToShorten)
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .statusCode(200)
                .body("result_url", notNullValue());
    }

    @ParameterizedTest(name = "Тестовые данные: {0}")
    @CsvFileSource(resources = "/negative_test_url.csv")
    @DisplayName("Передаем негативные url для изменения - 400 Bad Request")
    public void testNegativeShortenUrlError(String urlToShorten) {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("url", urlToShorten)
                .when()
                .post("https://cleanuri.com/api/v1/shorten")
                .then()
                .statusCode(400)
                .body("error", notNullValue());
    }
}
