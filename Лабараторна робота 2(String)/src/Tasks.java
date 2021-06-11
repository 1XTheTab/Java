import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Tasks {
    /*
     * 22. а) підраховує кількість розділових знаків у тексті;
     * б) виводить всі слова, що мають парну кількість літер.
     * */
    public static void task1() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок : ");
        String str = scanner.nextLine();

        if (str.length() == 0) {
            throw new IOException("Не був введений рядок!");
        }

        System.out.println("\nРезультат :");
        task1_a(str);
        task1_b(str);
    }

    //а) підраховує кількість розділових знаків у тексті;
    private static void task1_a(String str){
        int length1 = str.length();
        str = str.replaceAll("[,.!?;:]", "");
        int length2 = str.length();

        int result = length1 - length2;

        System.out.println("а)Кількість розділових знаків у тексті = " + result);
    }

    //б) виводить всі слова, що мають парну кількість літер.
    private static void task1_b(String str){
        str = str.replaceAll("[,.!?;:]", "");
        String[] words = str.split("[\\s]+");

        System.out.println("\nб)Cлова, що мають парну кількість літер :");
        for (String p : words)
            if(p.length() % 2 == 0)
                System.out.print(p + " ");

        System.out.println();
    }



    /*
    * 22. На диску D міститься файл 222.txt з числами (записаними через пробіл).
    * Знайти кількість чисел, що знаходяться у вказаному діапазоні [a, b].
    * Параметри a та b вводяться з клавіатури. Записати в кінець файлу цю кількість.
    * */
    public static void task2(String filepath) throws IOException {
        String text = inputFile(filepath);

        text = text.replaceAll("[!,?;:'\"]", "");
        String[] words = text.split("[\\s]+");

        if(words.length <= 0) throw new IOException("Файл пустий.");

        double[] mas = new double[words.length];
        for (int i = 0; i < words.length; i++)
            mas[i] = Double.parseDouble(words[i]);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число 'a' : ");
        int a = scanner.nextInt();
        System.out.print("Введіть число 'b' : ");
        int b = scanner.nextInt();

        if(a > b) throw new IOException("'a' не може бути більшим за 'b'!");

        int count = 0;
        for(double d : mas){
            System.out.print(d + " ");
            if(a <= d && d <= b)
                count++;
        }
        System.out.println();

        System.out.println("Кількість чисел, що знаходяться у вказаному діапазоні [" + a + ";" + b + "] = " + count);
        outputFile(filepath, (text + " " + count));
    }



    /*
    * б) виводить на екран слова, що починаються з приголосних літер.
     * */
    public static void task3(String inputPath, String outputPath) throws IOException {
        String text = inputFile(inputPath);

        text = text.replaceAll("[.!,?;:'\"]", "");
        String[] words = text.split("[\\s]+");

        if(words.length <= 0) throw new IOException("Файл пустий.");

        //масив char голосних букв
        char[] vowels={'e', 'y', 'u', 'i', 'o', 'a', 'у', 'е', 'ї', 'і', 'а', 'о', 'є', 'я', 'и', 'ю'};

        String result = "";

        System.out.println("Текст :" + "\n" + text);
        System.out.println("Cлова, що починаються з приголосних літер : ");
        for (String p : words) {
            boolean flag = true;
            for(char ch : vowels)
            if (p.charAt(0) == ch || p.charAt(0) == Character.toUpperCase(ch)) {
                flag = false;
                break;
            }

            if (flag)
                result += p + " ";
        }

        outputFile(outputPath, result);
        System.out.println(result);
    }


    private static void isFile(String filepath) throws IOException{
        //перевірка чи файл існує
        File file = new File(filepath);
        if(!file.isFile()) throw new IOException("Файл не знайдено!");
    }

    private static void createFile(String filepath) throws IOException{
        //перевірка чи файл існує
        File file = new File(filepath);
        if(!file.isFile())
            file.createNewFile();
    }

    private static void outputFile(String filepath, String text) throws IOException{
        isFile(filepath);

        //записуємо в файл
        BufferedWriter output = new BufferedWriter(new FileWriter(filepath));
        output.write(text);
        output.flush();
        output.close();
    }


    private static String inputFile(String filepath) throws IOException {
        isFile(filepath);

        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String text;
        StringBuilder lines = new StringBuilder();
        //зчитуємо текст з файлу
        while ((text = reader.readLine()) != null) {
            lines.append(text);
        }
        reader.close();
        return lines.toString();
    }
}
