package ru.academits.java;

import java.time.LocalDate;

public class Person {
    // Поля класса
    private String name;
    private String middleName;
    private String familyName;
    private int age;
    private static final int MIN_AGE = 0;

    // Конструктор класса (прямое присваивание)
    public Person(String name, String middleName, String familyName, int age) {
            this.name = name;
            this.middleName = middleName;
            this.familyName = familyName;
            this.age = age;
    }

    // Метод для проверки строки на содержание цифр
    private boolean containsDigits(String input) {
        if (input == null) return false;
        return input.matches(".*\\d.*"); // Для поиска цифр
    }

    // Геттеры - методы для получения значений полей
    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getAge() {
        return age;
    }

    public int getBirthYear() {
        return LocalDate.now().getYear() - age;
    }

    // Сеттеры - методы для установки значений полей (с валидацией и выводом сообщений)
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println("Имя не было изменено, передано пустое значение");
        } else if (containsDigits(name)) {
            System.out.println("Имя не было изменено: содержит цифры");
        } else {
            this.name = name;
            System.out.println("Имя было изменено");
        }
    }

    public void setMiddleName(String middleName) {
        if (middleName == null || middleName.isEmpty()) {
            System.out.println("Отчество не было изменено, передано пустое значение");
        } else if (containsDigits(middleName)) {
            System.out.println("Отчество не было изменено: содержит цифры");
        } else {
            this.middleName = middleName;
            System.out.println("Отчество было изменено");
        }
    }

    public void setFamilyName(String familyName) {
        if (familyName == null || familyName.isEmpty()) {
            System.out.println("Фамилия не была изменена, передано пустое значение");
        } else if (containsDigits(familyName)) {
            System.out.println("Фамилия не была изменена: содержит цифры");
        } else {
            this.familyName = familyName;
            System.out.println("Фамилия была изменена");
        }
    }

    public void setAge(int age) {
        if (age >= MIN_AGE) {
            this.age = age;
            System.out.println("Возраст изменен на " + age);
        } else {
            System.out.println("Ошибка: возраст не может быть отрицательным");
        }
    }

    // Метод toString() для строкового представления объекта
    @Override
    public String toString() {
        return String.format(
                "%s %s %s (Возраст: %d, Год рождения: %d)",
                familyName, name, middleName, age, getBirthYear());
    }
}

