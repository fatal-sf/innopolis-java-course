package homework4;

import java.util.Arrays;

public class HomeWork4Task3 {
    public static void main(String[] args) {
    /*
    Задача 3*. Задана строка, состоящая из букв английского алфавита,
разделенных одним пробелом. Необходимо каждую последовательность
символов упорядочить по возрастанию и вывести слова в нижнем регистре.
Входные данные: в единственной строке последовательность символов
представляющее два слова.
Выходные данные: упорядоченные по возрастанию буквы в нижнем
регистре.
     */
        //Задаем строку из букв английского алфавита разделенную пробелом.
        String mainLine = "Hello World";
        System.out.println("Исходная строка : " + mainLine);
        //Иницииализируем объект класса StringBuiler для последующего склеивания обработанного результата в одну строку
        StringBuilder newLine = new StringBuilder();
        //Создаем вспомогательный массив из строк разделенных пробелами, в т.ч. приводим к нижнему регистру
        String [] lineArray = mainLine.toLowerCase().split(" ");
        //Создаем вспомогательный массив из символов, который будем использовать для сортировки.
        char [] charBuff;
        //В цикле пробегаемся по массиву строк, каждую строку делим на массив из символов, сортируем и перезаписываем отсортированную строку
        for (int i = 0; i < lineArray.length; i++){
            charBuff = lineArray[i].toCharArray();
            Arrays.sort(charBuff);
             lineArray[i] = String.valueOf(charBuff);
        }

        //Делаем единую строку из массива отсортированных строку
        for (String word: lineArray){
            newLine.append(word);
            newLine.append(" ");
        }
        System.out.println("Строка после сортировки : " + newLine);
        }


    }

