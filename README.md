
# Yandex.Practicum project №3

## Dependencies:

* ### Google Chrome 133.0.6943.127
* ### Яндекс.Браузер 25.2.0.2123 (chromium 132.0.6834.2123)
* Java 11
* JUnit 4.13.2
* REST Assured 5.4.0
* Selenium Java 4.5.0
* WebDriverManager 5.8.0
* Google Gson 2.10.1
* allure-junit4 2.24.0
* allure-rest-assured 2.24.0


Test Object - https://stellarburgers.nomoreparties.site/

API Docs - https://code.s3.yandex.net/qa-automation-engineer/java/cheatsheets/paid-track/diplom/api-documentation.pdf

## Running Tests

По умолчанию тесты запускаются в Google Chrome:

```bash
  mvn clean test
```

Чтобы запустить тесты в Яндекс.Браузер необходимо добавить параметр:

```bash
  mvn clean test -Dbrowser=yandex
```

