package ru.academits.java;

import java.time.LocalDate;

public class Person {
    // Поля класса
    private String name;
    private String middleName;
    private String familyName;
    private int age;
    private int birthYear;

    // Конструктор класса
    public Person(String name, String middleName, String familyName, int age, boolean silent) {
        if (!silent) {
            // Устанавливаем значения через сеттеры (с валидацией и сообщениями)
            setName(name);
            setMiddleName(middleName);
            setFamilyName(familyName);
            setAge(age);
        } else {
            // Прямое присваивание без валидации
            this.name = name;
            this.middleName = middleName;
            this.familyName = familyName;
            this.age = age;
            this.birthYear = LocalDate.now().getYear() - age;
        }
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
        return birthYear;
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
            System.out.println("Фамилия была изменено");
        }
    }

    public void setAge(Integer age) {
        if (age >= 0) {
            this.age = age;
            this.birthYear = LocalDate.now().getYear() - age; // Автоматическое обновление года рождения
            System.out.println("Возраст изменен на " + age +
                    ", год рождения обновлен: " + this.birthYear);
        } else {
            System.out.println("Ошибка: возраст не может быть отрицательным");
        }
    }

    public void setBirthYear(int birthYear) {
        int currentYear = LocalDate.now().getYear();
        if (birthYear <= currentYear) {
            this.birthYear = birthYear;
            this.age = currentYear - birthYear;  // Пересчитываем возраст автоматически
            System.out.println("Год рождения изменен на " + birthYear +
                    ", возраст обновлен: " + this.age);
        } else {
            System.out.println("Ошибка: год рождения не может быть в будущем");
        }
    }


    // Метод toString() для строкового представления объекта
    @Override
    public String toString() {
        return String.format(
                "%s %s %s (Возраст: %d, Год рождения: %d)",
                familyName, name, middleName, age, birthYear);
    }
}

