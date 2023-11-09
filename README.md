# Технические требования

- Java 11
- Spring 2.7.15
- Gradle 7.5.1
- Docker & Docker-compose

## Подготовка к запуску

Перед запуском приложения выполните следующие шаги:

1. Запустите PostgreSQL и Elasticsearch & Kibana через Docker-compose.
   Файлы находятся в директории `src/main/docker`.
    - `docker-compose -f postgresql.yml up -d`
    - `docker-compose -f es_kibana.yml up -d`

## Доступ к API

После успешного запуска приложения, API будет доступен через Swagger по следующему адресу:

- [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Авторизация

Для работы с API необходимо авторизоваться (в Swagger также присутствует кнопка Authorize).
В системе есть два пользователя:

1. Логин: user, Пароль: user - Пользователь
2. Логин: admin, Пароль: user - Модератор

## Логирование

Логи приложения будут доступны в Kibana после взаимодействия с API.
Страницу Kibana можно посмотреть по адресу:

- [localhost:5601](localhost:5601)

Для просмотра логов необходимо связать индекс Elasticsearch в Kibana:
1. Перейдите в раздел Index pattern.
2. Создайте индекс с названием 'airastana'.
3. Нажмите "Create".

После этого перейдите в раздел Explore, где будут отображаться логи.

Спасибо!