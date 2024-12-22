import java.util.Scanner;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println("Задание №1");
        // Задача 1. Напишите Java-программу для преобразования температуры изФаренгейта в градусы Цельсия.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите градусы:");
        //Записываем в переменную то что ввел пользователь, приводим к нужному типу
        double fahrenheitValue = scanner.nextDouble();
        //Переводим температуру к цельсию по формуле (фаренгейт - 32) : 1.8
        double celsiusValue = ((fahrenheitValue - 32) / 1.8);
        System.out.println(fahrenheitValue + " градусов по Фаренгейту равна " + celsiusValue + " по Цельсию");
        System.out.println("***");


        System.out.println("Задание №2");
        /*Задача 2.  Напишите программу на Java, которая принимает два целыхчисла от пользователя, а затем печатает сумму, разницу, произведение, среднеезначение,
        расстояние (разница между целыми числами), максимум (большее издвух целых чисел), минимум (меньшее из двух целых чисел).
         */

        //Новый экземпляр объекта типа сканнер не создаю осознано, т.к. хочу избежать дублирования.
        System.out.println("Введите два целых числа X и Y:");
        //Записываем первое число.
        int x = scanner.nextInt();
        //Записываем второе число.
        int y = scanner.nextInt();
        System.out.println("Результат:");
        System.out.println("Сумма двух целых чисел: " + (x + y));
        System.out.println("Разница двух целых чисел: " + (x - y));
        System.out.println("Произведение из двух целых чисел: " + (x * y));
        System.out.println("Среднее из двух целых чисел: " + (double)((x+y)/2));
        System.out.println( "Расстояние двух целых чисел: " + Math.abs(x-y));
        System.out.println("Максимальное целое число: " + Math.max(x,y));
        System.out.println("Минимальное целое число: " + Math.min(x,y));
        System.out.println("***");

        System.out.println("Задание №3");
        // Задача 3*. Напишите Java-программу для объединения данной строки ссамим собой заданное количество раз
        // Новый экземпляр объекта типа сканнер не создаю осознано, т.к. хочу избежать дублирования.
        System.out.println("Сколько раз вывести строку?");
        // Создаю переменную типа int, записываю в нее количество повторений
        int countOfRepeat = scanner.nextInt();
        scanner.nextLine();//очищаю буфер ввода
        // Создаю переменную типа String, записываю в нее строку
        System.out.println("Исходная строка:");
        String line = scanner.nextLine();
        // Вывожу в цикле строку заданное количество раз
        for(int i = 0; i < countOfRepeat;i++){
            System.out.print(line);
        }
        System.out.println("");
        System.out.println("***");
        System.out.println("Задание №4");
        // Задача 4*. Напишите программу на Java для печати сетки из заданныхэлементов.
        //Новый экземпляр объекта типа сканнер не создаю осознано, т.к. хочу избежать дублирования.
        //Создаем переменную для хранения количества строк и столбцов и записываем в нее данные из консоли
        System.out.println("Введите число строк и столбцов сетки:");
        int columnsRowsCount = scanner.nextInt();
        scanner.nextLine();//очищаю буфер ввода
        //Создаем переменную для хранения повторяемого элемента сетки, записываем в нее данные из консоли
        System.out.println("Введите повторяемый элемент сетки:");
        String element = scanner.nextLine();
        System.out.println("Сетка по запросу " + columnsRowsCount +  " на " + columnsRowsCount);

        //Создаю два цикла внешний для строк, внутренний для столбцов конкретной строки

        for(int i = 0; i < columnsRowsCount; i++){
            for(int k = 0; k <columnsRowsCount; k++){
                System.out.print(element);
            }
            System.out.println();
        }
        }


    }

