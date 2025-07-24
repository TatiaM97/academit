package ru.academits.java;

public class CycleFor {

    // Метод для проверки, делится ли число на 4 без остатка
    public static boolean isMultipleOfFour(int number) {
        return number % 4 == 0;
    }

    public static void main(String[] args) {
        for // Цикл от 1 до 100 (вспомогательный индекс i)
        (
                int i = 1;
                i <= 100;
                i++
        ) {
            int reverseNumber = 101 - i; // Преобразуем i в убывающее число от 100 до 1

            // Проверяем, кратно ли число 4
            if (isMultipleOfFour(reverseNumber)) {
                System.out.print(reverseNumber + " "); // Выводим число с пробелом
            }
        }
    }
}

