package ua.khpi.oop.abdulaev02;

import java.util.Random;

public class Main {
    /**
     * Розрахунок НСД для двох позитивних чисел
     * @param x перше число
     * @param y друге число
     * @return найбільший спільний дільник
     */
    public static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    /**
     * Виведення табличного рядка з інформацією про тест
     * @param i номер тесту
     * @param x перше число
     * @param y друге число
     * @param res нсд чисел
     */
    public static void log(int i, int x, int y, int res) {
        System.out.printf(
                "| Test%1$3d | x = %2$4d | y = %3$4d | НСД(x,y) = %4$3d |%n|",
                i, x, y, res
        );
        System.out.println("--------------------------------------------------");
    }

    /**
     * Запуск тестів розрахунку нсд двох чисел
     * @param testsCount кількість тестів
     */
    public static void solve(int testsCount) {
        Random random = new Random();
        int bounds = 100;
        int x, y;

        for (int i = 0; i < testsCount; i++) {
            x = random.nextInt(bounds);
            y = random.nextInt(bounds);
            log(i + 1, x, y, gcd(x, y));
        }
    }

    public static void main(String[] args) {
        solve(100);
    }
}
