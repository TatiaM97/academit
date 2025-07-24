package ru.academits.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаем тестовый объект Person с помощью конструктора с silent = true (без вывода сообщений)
        Person person = new Person("Кот", "Котофеевич", "Котофеев", 5, true);

        // Выводим исходную информацию с помощью toString()
        System.out.println("Данные пользователя: " + person);

        // Меню взаимодействия
        while (true) {
            try {
                System.out.println("\nВыберите действие: ");
                System.out.println("1 - Показать информацию о пользователе");
                System.out.println("2 - Изменить имя");
                System.out.println("3 - Изменить отчество");
                System.out.println("4 - Изменить фамилию");
                System.out.println("5 - Изменить возраст");
                System.out.println("6 - Изменить год рождения");
                System.out.println("7 - Показать год рождения");
                System.out.println("0 - Выход");
                System.out.println("Ваш выбор: ");

                String input = scanner.nextLine().trim();

                //Обработка пустого ввода
                if (input.isEmpty()) {
                    System.out.println("Ошибка: введите номер пункта меню");
                    continue;
                }

                int choice;
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: введите число от 0 до 7");
                    continue;
                }
                // Обработка выбора
                switch (choice) {
                    case 1: // Вывод текущих данных
                        System.out.println("\nТекущая информация:");
                        // Используем геттеры для получения значений
                        System.out.println("Имя: " + person.getName());
                        System.out.println("Отчество: " + person.getMiddleName());
                        System.out.println("Фамилия: " + person.getFamilyName());
                        System.out.println("Возраст: " + person.getAge());
                        System.out.println("Год рождения: " + person.getBirthYear());
                        break;

                    case 2: // Изменение имени с валидацией
                        while (true) {
                            System.out.println("Введите имя: ");
                            String newName = scanner.nextLine().trim();
                            if (!newName.isEmpty() && !newName.matches(".*\\d.*")) {
                                person.setName(newName);
                                break;
                            }
                            System.out.println("Ошибка: имя не может быть пустым или содержать цифры. Попробуйте снова");
                        }
                        break;

                    case 3: // Изменение отчества
                        while (true) {
                            System.out.print("Введите отчество: ");
                            String newMiddleName = scanner.nextLine().trim();
                            if (!newMiddleName.isEmpty() && !newMiddleName.matches(".*\\d.*")) {
                                person.setMiddleName(newMiddleName);
                                break;
                            }
                            System.out.println("Ошибка: отчество не может быть пустым или содержать цифры. Попробуйте снова.");
                        }
                        break;

                    case 4: // Изменение фамилии
                        while (true) {
                            System.out.print("Введите фамилию: ");
                            String newFamilyName = scanner.nextLine().trim();
                            if (!newFamilyName.isEmpty() && !newFamilyName.matches(".*\\d.*")) {
                                person.setFamilyName(newFamilyName);
                                break;
                            }
                            System.out.println("Ошибка: фамилия не может быть пустым или содержать цифры. Попробуйте снова.");
                        }
                        break;

                    case 5: // Изменение возраста
                        while (true) {
                            System.out.print("Введите возраст: ");
                            String ageInput = scanner.nextLine().trim();

                            if (ageInput.isEmpty()) {
                                System.out.println("Ошибка: возраст не может быть пустым");
                                continue;
                            }

                            try {
                                int newAge = Integer.parseInt(ageInput);
                                if (newAge >= 0 && newAge <= 100) {
                                    person.setAge(newAge);
                                    break;
                                }
                                System.out.println("Ошибка: возраст должен быть от 0 до 100 лет");
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: введите целое число");
                            }
                        }
                        break;

                    case 6: // Изменение года рождения
                        int currentYear = LocalDate.now().getYear();
                        while (true) {
                            try {
                                System.out.print("Введите год рождения (" + (currentYear - 100) + "-" + currentYear + "): ");
                                String yearInput = scanner.nextLine().trim();

                                if (yearInput.isEmpty()) {
                                    System.out.println("Ошибка: год рождения не может быть пустым");
                                    continue;
                                }

                                int newBirthYear = Integer.parseInt(yearInput);
                                if (newBirthYear >= (currentYear - 100) && newBirthYear <= currentYear) {
                                    person.setBirthYear(newBirthYear);
                                    break;
                                }
                                System.out.println("Ошибка: год рождения должен быть между " +
                                        (currentYear - 100) + " и " + currentYear);
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: введите целое число");
                            }
                        }
                        break;

                    case 7:
                        System.out.println("\nГод рождения: " + person.getBirthYear());
                        break;


                    case 0:
                        System.out.println("Программа завершена.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Неверный ввод, попробуйте снова.");
                }

                // Пауза перед возвратом в меню
                System.out.print("\nНажмите Enter для продолжения...");
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
                scanner.nextLine(); // Очистка ввода в случае ошибки
            }
        }
    }
}

