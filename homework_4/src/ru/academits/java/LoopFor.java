package ru.academits.java;

public class LoopFor {

    // Метод для проверки, делится ли число на 4 без остатка
    public static boolean isMultipleOfFour(int number) {
        return number % 4 == 0;
    }

    public static void main(String[] args) {
        for // Цикл от 100 до 1 (вспомогательный индекс i)
        (
                int i = 100;
                i >= 1;
                i--
        ) {
            // Проверяем, кратно ли число 4
            if (isMultipleOfFour(i)) {
                System.out.print(i + " "); // Выводим число с пробелом
            }
        }
    }
}

