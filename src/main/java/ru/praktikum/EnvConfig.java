package ru.praktikum;

public class EnvConfig {
    public static final int DEFAULT_TIMEOUT = 10;

    public static final String CHROME_DRIVER = System.getProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    public static final String CHROME_BINARY = System.getProperty("webdriver.chrome.binary", "C:/Program Files/Google/Chrome/Application/chrome.exe");
    public static final String YANDEX_DRIVER = System.getProperty("webdriver.yandex.driver", "src/main/resources/yandexdriver.exe");
    public static final String YANDEX_BINARY = System.getProperty("webdriver.yandex.binary", "C:/Users/ellynale/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");

}
