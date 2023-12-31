<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
<div align="center">
<h2 align="center">Four test items (Web/API)</h2>
  <p align="center">
    Четыре тестовых задания, которые написаны с использованием технологий Web и API.

 <br /> Тестирование веб-приложения. 
    <br />
    <a href="https://github.com/NickoT88/Four_test_items"><strong>Explore the docs</strong></a>
    <br />
  </p>
</div>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

**Задание 1: API:** Написать автотесты для тестирования api сервиса <a href="https://cleanuri.com/docs">cleanui.com</a>
- 1.1. Выполнить тест-дизайн / составить тестовый набор (положительные + отрицательные сценарии) и покрыть его автотестами.
- 1.2. Тестовые данные (строка со ссылкой на сайт, которая будет "укорачиваться" в рамках работы тестируемого сервиса) необходимо вычитывать из внешнего файла.

**Задание 2: API:** Написать автотесты для тестирования api сервиса <a href="https://randomuser.me/documentation">randomuser.me</a>
- 2.1. Выполнить тест-дизайн / составить тестовый набор (положительные + отрицательные сценарии) и покрыть его автотестами.
- 2.2. При выполнении api-запросов необходимо использовать query-параметры (например, gender=male или results=2).
- 2.3. Ответы сервиса необходимо распарсить в Java-объекты и выполнить проверки (asserts) с использованием этих объектов (рекомендовано применение коллекций и stream api).

**Задание 3: Web:** Написать автотесты для тестирования <a href="https://demoqa.com/automation-practice-form">формы</a>
- 3.1. Заполнить форму валидными данными (все поля).
- 3.2. Нажать на кнопку Submit.
- 3.3. Проверить корректность заполнения формы (результаты во всплывающем окне "Thanks for submitting the form").
- 3.4. Также реализовать негативные проверки формы (валидация полей).

**Задание 4: Web:** Написать автотест для страницы сайта <a href="https://people.sovcombank.ru/vacancies">people.sovcombank.ru/vacancies</a>
- 4.1. Перейти на страницу <a href="https://people.sovcombank.ru/">people.sovcombank.ru</a>
- 4.2. Нажать на кнопку "Вакансии".
- 4.3. Выбрать в фильтре вакансий Город = "Москва", Компания = "Совкомбанк Технологии".
- 4.4. Собрать в коллекцию результаты работы фильтра (все найденные после фильтрации вакансии).
- 4.5. Проверить, что у всех найденных результатов указан город "Москва" и компания "Совкомбанк Технологии".
- 4.6. Рекомендуется применение паттерна PageObject.
- 4.7. Использование локаторов - css или xpath.

**Требования к стеку технологий и ПО:**
1. Java 8 и выше
2. Maven
3. JUnit 5
4. IDE IntelliJ Idea
5. Rest Assured для api-тестов
6. Selenium или Selenide для UI-тестов (браузер - chrome)
7. Asserts - AsserJ или Hamcrest
8. Проект с тестами разместить в github/gitlab (можно оформить все задания в рамках одного репозитория)

**P.S.:** пока выполнены 1 и 3 задания.

### Built With

* <a href="https://www.java.com/ru/">Java 11</a>
* <a href="https://junit.org/junit5/">Junit 5</a>
* <a href="https://rest-assured.io/">REST Assured</a>
* <a href="https://github.com/allure-framework/">Allure Framework</a>
* <a href="https://mvnrepository.com/artifact/com.google.code.gson/gson">Gson</a>
* <a href="https://www.selenium.dev">Selenium</a>


<!-- CONTACT -->

## Contact

Николай Токарев - [@tokarevnickolay](https://t.me/tokarevnickolay) - Tibibo88@yandex.ru

Project Link: [https://github.com/NickoT88/Four_test_items](https://github.com/NickoT88/Four_test_items)
