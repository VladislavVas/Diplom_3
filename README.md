# Diplom_3

Запуск тестов: 
mvn -Dwebdriver.chrome.driver=[путь к драйверу] -Dwebdriver.chrome.binary=[путь к бинарному файлу браузера] -Dbrowser=[браузер]
mvn -Dwebdriver.yandex.driver=[путь к драйверу] -Dwebdriver.yandex.binary=[путь к бинарному файлу браузера] -Dbrowser=yandex test

Соотвествующие переменные представлены в классе EnvConfig.

Для просмотря отчета: mvn allure:serve
