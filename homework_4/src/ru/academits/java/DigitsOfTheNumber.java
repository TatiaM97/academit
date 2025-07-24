package ru.academits.java;

import java.util.Scanner;

public class DigitsOfTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int digit;

        // Бесконечный цикл до получения корректного целого числа
        while (true) {
            System.out.println("Введите целое число: ");
            String input = scanner.nextLine();

            try {
                // Пробуем преобразовать в число
                digit = Integer.parseInt(input); // Преобразуем строку в int
                break; // Если успешно — выходим из цикла
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено не число или пустое значение!");
            }
        }

        scanner.close();

        int sumAll = 0; // Сумма всех цифр
        int sumOdd = 0; // Сумма нечетных цифр
        int maxDigit = digit % 10; // Первая цифра - начальное значение
        int originalDigit = digit; // Сохраняем исходное число для вывода

        digit = Math.abs(digit); // // Работаем с модулем числа (отрицательные игнорируются)

        // Разбор числа по цифрам справа налево
        while (digit != 0) {
            int currentDigit = digit % 10; // Получаем последнюю цифру
            sumAll += currentDigit; // Добавляем к сумме всех цифр

            if (currentDigit % 2 != 0) { // Если цифра нечетная
                sumOdd += currentDigit; // Добавляем к сумме нечетных
            }

            if (currentDigit > maxDigit) { // Если текущая цифра больше максимальной — обновляем
                maxDigit = currentDigit;
            }
            digit /= 10; // Удаляем последнюю цифру (сдвиг числа)
        }

        // Вывод результатов
        System.out.println("Сумма цифр числа " + originalDigit + " равна: " + sumAll);
        System.out.println("Сумма нечетных цифр числа " + originalDigit + " равна: " + sumOdd);
        System.out.println("Максимальная цифра в числе: " + maxDigit);
    }
}
