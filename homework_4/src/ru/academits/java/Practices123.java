package ru.academits.java;

import java.util.Scanner; // Импорт класса Scanner для чтения ввода с клавиатуры

public class Practices123 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Создание объекта Scanner

        String name;
        do {
            System.out.println("Введите ваше имя: "); // Просим пользователя ввести имя
            name = scanner.nextLine(); // Считываем введённое имя
        }
        while (name.isEmpty()); // Повторяем, пока строка пустая

        // Старый вариант логики:
        //System.out.println("Введите ваше имя: ");
        //String name = scanner.nextLine();
        // if (!name.isEmpty()) {

        System.out.println("Привет, " + name + "!"); // Выводим приветствие с именем

        scanner.close(); // Освобождаем ресурсы

        // Альтернативный вариант, если бы не было проверки через do-while:
        // } else {
        //     System.out.println("Привет, неизвестный!");
        // }
    }
}

