package com.example.naumenjavatask2.Tasks.Task5;

import java.util.LinkedList;
import java.util.Queue;

interface Task {
    /**
     * Запускает задачу
     */
    void start();

    /**
     * Останавливает задачу
     */
    void stop();
}

public class Task5  implements Task {

    private final Queue<String> queue;
    private volatile boolean running;

    public Task5() {
        this.queue = new LinkedList<>();
        this.running = false;
    }

    /**
     * Добавляет элемент в очередь
     *
     * @param item элемент для добавления
     */
    public void addItem(String item) {
        synchronized (queue) {
            queue.add(item);
            queue.notifyAll();
        }
    }

    @Override
    public void start() {
        running = true;
        new Thread(() -> {
            while (running) {
                String item;
                synchronized (queue) {
                    while (queue.isEmpty() && running) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    item = queue.poll();
                }
                if (item != null) {

                    processItem(item);
                }
            }
        }).start();
        System.out.println("Задача запущена.");
    }

    @Override
    public void stop() {
        running = false;
        synchronized (queue) {
            queue.notify(); // Уведомляем поток, чтобы он вышел из ожидания
        }
        System.out.println("Задача остановлена.");
    }

    private void processItem(String item) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Обработка элемента: " + item);
    }

    public static void main(String[] args) throws InterruptedException {
        var task = new Task5();
        task.start();

        for (var i = 0; i < 100; i++){
            task.addItem(i+1+" элемент");
        }

        Thread.sleep(2000);
        task.stop();
        Thread.sleep(2000);
        task.start();
    }
}
