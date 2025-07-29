package ru.academits.java;

import java.util.Scanner;

public class ArithmeticMean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Получаем первое число (>1)
        int number1;
        while (true) {
            System.out.println("Введите первое целое число (>1): ");
            String input = scanner.nextLine();

            try {
                number1 = Integer.parseInt(input); // Преобразуем строку в целое число
                if (number1 > 1) { // Проверяем что число > 1
                    break; // Если условие выполнено, выходим из цикла
                } else {
                    System.out.println("Ошибка: число должно быть > 1!");
                }
            } catch (NumberFormatException e) {
                // Обработка ошибки, если пользователь ввёл не число
                System.out.println("Ошибка: введено пустое значение или не целое число!");
            }
        }
        // Получаем второе число (> первого числа)
        int number2;
        while (true) {
            System.out.println("Введите второе целое число (> " + number1 + "): ");
            String input = scanner.nextLine();
            try {
                number2 = Integer.parseInt(input);
                if (number2 > number1) { // Убедимся, что второе число больше первого
                    break;
                } else {
                    System.out.println("Ошибка: число должно быть больше первого!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено пустое значение или не целое число!");
            }
        }
        // Общий цикл для вычисления
        int sumAll = 0;
        int sumEven = 0;
        int countEven = 0;
        for (
                int i = number1;
                i <= number2;
                i++
        ) {
            sumAll += i;
            if (i % 2 == 0) { // Проверяем четное ли число
                sumEven += i;
                countEven++;
            }
        }
        int countAll = number2 - number1 + 1;
        double averageAll = (double) sumAll / countAll; // Среднее арифметическое всех чисел
        double averageEven = countEven > 0 ? (double) sumEven / countEven : 0; // Среднее арифметическое четных чисел

        //Выводим результаты
        System.out.printf("\nРезультаты для диапазона [%d, %d]:\n", number1, number2);
        System.out.printf("Среднее арифметическое всех чисел: %.2f\n", averageAll);
        System.out.printf("Среднее арифметическое чётных чисел: %.2f\n", averageEven);

        scanner.close();
    }
}

