package homework4;

import java.util.Scanner;

public class HomeWork4Task1 {


    public static void main(String[] args) {
           /*
        Задача 1.Для введенной с клавиатуры буквы английского алфавита нужно вывести слева стоящую букву на стандартной клавиатуре.
        При этом клавиатура замкнута, т.е.справа от буквы «p» стоит буква «a», а слева от "а" буква "р", так же соседними считаются буквы «l» и буква «z», а буква «m» с буквой «q».
        Входные данные: строка входного потока содержит один символ — маленькую букву английского алфавита.
        Выходные данные:следует вывести букву стоящую слева от заданной буквы, с учетом замкнутости клавиатуры.
         */

        //Решаю без использования регулярок, не было времени плотно ознакомиться с темой.
        Scanner scanner = new Scanner(System.in);
        //Завожу массив согласно условию задачи
        String[] lettersArray = {"m","q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
        System.out.println("Введите любую английскую букву в нижнем регистре:");
        //Считываю букву из консоли и записываю в переменную
        String userLetter = scanner.next();
        //Завожу переменную для индекса искомой буквы
        int letterIndex = -1;
        //Сравниваю в цикле заданную пользователем букву и элементы массива, при нахождении записываю индекс буквы слева от нее.
        for(int i = 1; i < lettersArray.length; i++){
            if(lettersArray[i].equals(userLetter)){
                letterIndex = i-1;
            }
        }
        if (letterIndex == -1) {
            System.out.println("Введенная буква не соответствует условиям");
        } else {
            System.out.println("Предыдущая буква:");
            System.out.println(lettersArray[letterIndex]);
        }
    }

}
