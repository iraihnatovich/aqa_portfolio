**Основное задание**:
1. 	Реализовать фреймворк согласно индивидуальному заданию
2. 	Создать public Git репозиторий содержащий финальный результат дипломной работы
3. 	Реализовать следующий набор UI тестов:


      a. 	6 позитивных тестов
      i. 	1 тест на проверку поля для ввода на граничные значения
      ii. 	1 тест на проверку всплывающего сообщения
      iii. 	1 тест на создание сущности
      iv. 	1 тест на удаление сущности
      v. 	1 тест отображения диалогового окна
      vi. 	1 тест на загрузку файла

      b. 	3 негативных теста
      i. 	1 тест на использование некорректных данных
      ii. 	1 тест на ввод данных превышающих допустимые
      iii. 	1 тест воспроизводящий любой дефект

4. 	Реализовать следующий набор API тестов:


         a. 	Get - 3 теста NFE + 2 теста AFE
         b. 	Post
5. 	Подключить Allure для формирования отчета
6. 	Настроить CI/CD систему для запуска теста и отображения отчета
7. 	Подготовить презентацию и защитить дипломную работу (2 человека одновременно):


      a. 	Рассказать преимущества выбранного фреймворка
      b. 	Рассказать об особенностях реализации
      c. 	Запуск тестов на CI/CD
      d. 	Презентовать отчет о выполнении


**GIT STRATEGY**

·      _master_ — main branch

·      _develop_ — the main development branch. Each commit to the develop branch is a result of a feature development completion. Each commit should be a result of a merge of merge request from a feature branch.

·      _feature_ — each new feature should reside in its own branch, which is created off of the latest develop version. When a feature is complete, it gets merged back into develop via merge request. After the feature branch is deleted.

**Индивидуальное задание** группы №1:

https://app.testiny.io

1. PageObject + Lombok + Builder + Selenium WD + TestNG + Wrappers
2. Прогон c параллельным запуском (Smoke and Regression)
3. Основное задание
4. Github Actions
5. Доп задание “Создать данные для тестов используя API, данные взять из JSON”
