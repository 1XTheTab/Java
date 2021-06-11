import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Tasks {
    /*
     22. Написати програму, яка в залежності від порядкового номера дня тижня (1,2,...7) виводить на екран його назву (понеділок,...)
     * */
    public void task1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число (1-7) : ");
        int nomer = scanner.nextInt();
        do {
            if (nomer >= 1 && nomer <= 7) {
                switch (nomer) {
                    case 1:
                        System.out.println("Понеділок");
                        break;
                    case 2:
                        System.out.println("Вівторок");
                        break;
                    case 3:
                        System.out.println("Середа");
                        break;
                    case 4:
                        System.out.println("Четверг");
                        break;
                    case 5:
                        System.out.println("П'ятниця");
                        break;
                    case 6:
                        System.out.println("Субота");
                        break;
                    case 7:
                        System.out.println("Неділя");
                        break;
                }
                break;
            } else {
                System.out.print("Введіть число (1-7): ");
                nomer = scanner.nextInt();
            }
        } while (true);
    }


    /*
     * 22. Протабулювати функцію y=f(x), з параметром x, який змінюється від 'a' до 'b' з кроком dx
     * */
    public void task2() {
        double a = -1, b = 25;
        double dx = 1.25;

//        for (double x = a; x <= b; x += dx) {
//            double y = Math.exp(x)/(3 * x - 12);
//            System.out.println("x = " + String.format("%.2f", x) + "\ty = "+ String.format("%.2f", y));
//        }

        double x = a;
        do {
            double y = Math.exp(x)/(3 * x - 12);
            System.out.println("x = " + String.format("%.2f", x) + "\ty = " + String.format("%.2f", y));
            x += dx;
        } while (x <= b);
    }


    /*
     * 22. Визначити 1) кількість від’ємних елементів масиву;
     * 2) суму елементів масиву, розташованих після мінімального елемента
     * */
    public void task3() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть розмірність масиву : ");
        int size = scanner.nextInt();
        while (true) {
            if (size <= 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть розмірність масиву : ");
                size = scanner.nextInt();
            } else break;
        }

        int[] mas = new int[size];
        System.out.println("1.Ввести масив з клавіатури.");
        System.out.println("2.Згенерувати масив.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести масив з клавіатури.");
                System.out.println("2.Згенерувати масив.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < mas.length; i++) {
                System.out.print("A [" + i + "] = ");
                mas[i] = scanner.nextInt();
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < mas.length; i++) {
                mas[i] = random.nextInt(200) - 100;
            }
        }
        for (int i : mas) {
            System.out.print(i + " ");
        }
        System.out.println();

        task3_1(mas);
        task3_2(mas);
    }

    //1) кількість від’ємних елементів масиву;
    private void task3_1(int[] mas) {
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < 0) {
                count++;
            }
        }

        System.out.println("Кількість від’ємних елементів масиву = " + count);
    }

    //2) суму елементів масиву, розташованих після мінімального елемента
    private void task3_2(int[] mas) throws IOException {
        int index = 0, min = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < min) {
                min = mas[i];
                index = i;
            }
        }

        if (index == mas.length - 1)
            throw new IOException("Нема елементів після мінімального елемента!");

        int suma = 0;
        for (int i = index; i < mas.length; i++) {
            suma += mas[i];
        }

        System.out.println("Сума елементів після мінімального елемента(" + mas[index] + ") = " + suma);
    }


    /*
     * 22. Дано цілочислову матрицю А розмірності nxm.
     * Вивести на екран вектор b, елементи якого є максимальними елементами кожного зі рядків.
     * */
    public void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть висоту матриці : ");
        int n = scanner.nextInt();
        System.out.print("Введіть ширину матриці : ");
        int m = scanner.nextInt();
        for (; ; ) {
            if (n < 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть висоту матриці : ");
                n = scanner.nextInt();
            }
            if (m < 0) {
                System.out.println("Не вірно введена розмірність!!! Повторіть спробу :");
                System.out.print("Введіть ширину матриці : ");
                m = scanner.nextInt();
            }
            if (n > 0 && m > 0) break;
        }
        int[][] mas = new int[n][m];
        System.out.println("1.Ввести матрицю з клавіатури.");
        System.out.println("2.Згенерувати матрицю.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        while (true) {
            if (num != 1 && num != 2) {
                System.out.println("Не вірно введене число!!! Повторіть спробу :");
                System.out.println("1.Ввести матрицю з клавіатури.");
                System.out.println("2.Згенерувати матрицю.");
                System.out.print("Введіть число : ");
                num = scanner.nextInt();
            } else break;
        }

        if (num == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print("A [" + i + "][" + j + "] = ");
                    mas[i][j] = scanner.nextInt();
                }
            }
        } else {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mas[i][j] = random.nextInt(200) - 100;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }

        task4_1(mas);
    }

    private void task4_1(int[][] mas) {
        int []vector = new int[mas.length];
        for (int i = 0; i < mas.length; i++) {
            int max = mas[i][0];
            for(int j = 0;j<mas[i].length;j++)
                if(mas[i][j] > max)
                    max = mas[i][j];

                vector[i] = max;
        }

        System.out.println("\nРезультат :");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
}
