package ru.praktikum;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.model.UserData;
import ru.praktikum.model.UserMapper;
import ru.praktikum.user_api.UserClient;

import java.io.File;
import java.time.Duration;

import static ru.praktikum.Constants.BASE_URL;

public class BaseTest {

    protected WebDriver driver;
    protected String url;
    protected UserClient userClient;
    protected UserData userData;
    protected UserMapper userMapper;

    @Before
    public void setUp() {
        this.userMapper = new UserMapper();
        this.userClient = new UserClient();
        this.userData = new UserData();
        this.url = BASE_URL;
        driverRule();
        driver.get(url);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    public void driverRule() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        if ("yandex".equals(System.getProperty("browser"))) {
            setYandex();
        } else {
            setChrome();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private void setChrome() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvConfig.CHROME_DRIVER))
                .build();

        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvConfig.CHROME_BINARY);

        this.driver = new ChromeDriver(service, options);
    }

    public void setYandex() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(EnvConfig.YANDEX_DRIVER))
                .build();
        ChromeOptions options = new ChromeOptions()
                .setBinary(EnvConfig.YANDEX_BINARY);

        this.driver = new ChromeDriver(service, options);
    }


}
