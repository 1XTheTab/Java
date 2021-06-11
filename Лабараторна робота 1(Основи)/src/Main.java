import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Перше завдання.");
        System.out.println("2. Друге завдання.");
        System.out.println("3. Третє завдання.");
        System.out.println("4. Четверте завдання.");
        System.out.println("5. Вихід.");
        System.out.print("Введіть число : ");
        int num = scanner.nextInt();
        Tasks tasks = new Tasks();
        while(num != 5){
            switch (num) {
                case 1:
                    tasks.task1();
                    break;
                case 2:
                    tasks.task2();
                    break;
                case 3:
                    try {
                        tasks.task3();
                    }
                    catch (IOException ex) {
                        System.err.println(ex.getMessage());
                    }
                    break;
                case 4:
                    tasks.task4();
                    break;
                default:
                    System.out.println("Не вірно введене число!!! Повторіть спробу :");
                    break;
            }
            System.out.println("1. Перше завдання.");
            System.out.println("2. Друге завдання.");
            System.out.println("3. Третє завдання.");
            System.out.println("4. Четверте завдання.");
            System.out.println("5. Вихід.");
            System.out.print("Введіть число : ");
            num = scanner.nextInt();
        }
    }
}