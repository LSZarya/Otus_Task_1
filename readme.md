# Запуск тестов _Otus_ дз. №1

## Запуск тестов происходит и файла _testng.xml_. Для запуска теста установите настройки запуска

---
### VM options:
### -Dbrowser=CHROME -DnameSpecialCourse=Android -DnamePopularCourse=PHP -DnameOpenCourse=1
---

---
### Прописать в терминале:
### mvn test -Dbrowser=CHROME -DnameSpecialCourse=Android -DnamePopularCourse=PHP -DnameOpenCourse=1
---

--
browser - выбор браузера.

--
nameSpecialCourse - Фильтр названия специального курса (Поиск курса по ключевым словам).

--
namePopularCourse - Фильтр названия популярного курса (Поиск курса по ключевым словам).

--
nameOpenCourse - выбор курса по порядку страницу, которого открыть. (Страница курса будет открыта, но проверка заголовка корректно работает на 1 станице, с сегодняшнего дня).

