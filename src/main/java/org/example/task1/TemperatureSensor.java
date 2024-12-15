package org.example.task1;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.subjects.PublishSubject;

import java.util.Random;

class TemperatureSensor extends Observable<Integer> {
    private final PublishSubject<Integer> subject = PublishSubject.create(); @Override
    protected void subscribeActual(Observer<? super Integer> observer) {
        subject.subscribe(observer); // Создаем подписку на события датчика температуры
    }
    public void start() {
        new Thread(() -> {
            while (true) {
                int temperature = new Random().nextInt(16) + 15; // Генерируем случайное значение температуры
                subject.onNext(temperature); // Отправляем значение температуры подписчикам
                try {
                    Thread.sleep(1000); // Пауза 1 секунда
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // Запускаем поток для симуляции работы датчика
    }
}
