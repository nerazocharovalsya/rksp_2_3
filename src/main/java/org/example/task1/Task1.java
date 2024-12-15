package org.example.task1;

// Будков Дмитрий ИКБО-01-21
public class Task1 {
    public static void main(String[] args) {
        TemperatureSensor temperatureSensor = new TemperatureSensor(); // Создаем датчик температуры
        CO2Sensor co2Sensor = new CO2Sensor(); // Создаем датчик CO2
        Alarm alarm = new Alarm(); // Создаем сигнализацию
        temperatureSensor.subscribe(alarm); // Подписываем сигнализацию на датчик температуры
        co2Sensor.subscribe(alarm); // Подписываем сигнализацию на датчик CO2
        temperatureSensor.start(); // Запускаем датчик температуры
        co2Sensor.start(); // Запускаем датчик CO2
        try {
            Thread.sleep(10000); // Запуск системы на 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}