# Weather Forecast WebFlux App
[![Build Status](https://travis-ci.com/denisRudie/weather-reactive.svg?branch=main)](https://travis-ci.com/denisRudie/weather-reactive)

### О проекте
Сервис для получения прогноза, используются механизмы реактивного программирования (Spring WebFlux).

### Technologies:
* Gradle
* Spring(Boot, WebFlux)

### REST API
| команда                               | запрос                                                           | ответ                                                                                                                                     |
|---------------------------------------|------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| получить прогноз во всех городах      | GET ```https://sitename/all```                                       | Код состояния: ```200``` Header: ```"Content-Type: text/event-stream"```  Body: ```[{"id":"", "city":"", "temperature":""}]``` |
| получить прогноз в конкретном городе  | GET ```https://sitename/get/{id}```                                  | Код состояния: ```200``` Header: ```"Content-Type: application/json"```  Body: ```{{"id":"", "city":"", "temperature":""}}```                                            |
| получить прогноз в городе с максимальной температурой | GET ```https://sitename/get/max``` | Код состояния: ```200``` Header: ```"Content-Type: application/json"``` Body: ```{"id":"", "city":"", "temperature":""}```                                                                              |
| получить прогноз в городах, в которых температура выше заданной | GET ```https://sitename/get/moreThan{temp}``` | Код состояния: ```200``` Header: ```"Content-Type: text/event-stream"``` Body: ```[{"id":"", "city":"", "temperature":""}]```                                                                              |
