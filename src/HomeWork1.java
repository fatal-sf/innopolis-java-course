public class HomeWork1 {
    public static void main(String[] args) {
        // Задача1.Составить программу вывода на экран в одну строку четырех любых чисел с тремя пробелами между ними

        int one = (int)(Math.random()*10);
        int two = (int)(Math.random()*10);
        int three = (int)(Math.random()*10);
        int four = (int)(Math.random()*10);

        System.out.println(one + " " + two + " " + three + " " + four);

        /* Задача 2*.Вася и Петя играют в игру “Камень, ножницы, бумага”. Каждый из них показывает свою фигуру камень-0,ножницы-1,бумага-2. Программа определяет,кто из них выиграл.Выбор каждого участника формируется случайным образом.

        Победитель определяется по следующим правилам:

        Бумага побеждает камень («бумага обёртывает камень»).
        Камень побеждает ножницы («камень затупляет ножницы»).
        Ножницы побеждают бумагу («ножницы разрезают бумагу»).
        */

        String [] stoneGame = {"Бумага","Камень","Ножницы"};
        String vasyaName = "Вася";
        String petyaName = "Петя";
        int vasyaChoice = (int)(Math.random()*3);
        int petyaChoice = (int)(Math.random()*3);
        String petyaWinner = "Победил Петя!";
        String vasyaWinner = "Победил Вася!";

        System.out.println(vasyaName + " показал: "+stoneGame[vasyaChoice]);
        System.out.println(petyaName + " показал: "+stoneGame[petyaChoice]);
        System.out.println("***");
        // Вася - Ножницы, Петя - Бумага и наоборот
        if(vasyaChoice == 2 && petyaChoice == 0){
            System.out.println(vasyaWinner);
        } else if (petyaChoice == 2 && vasyaChoice == 0) {
            System.out.println(petyaWinner);
            // Вася - Бумага, Петя - Камень и наоборот
        } else if (vasyaChoice == 0 && petyaChoice == 1) {
            System.out.println(vasyaWinner);
        } else if (vasyaChoice == 1 && petyaChoice == 0) {
            System.out.println(petyaWinner);
            // Вася - Камень, Петя - Ножницы и наоборот
        } else if (vasyaChoice == 1 && petyaChoice == 2) {
            System.out.println(vasyaWinner);
        } else if (vasyaChoice == 2 && petyaChoice == 1) {
            System.out.println(petyaWinner);
        } else {
            System.out.println("Победила дружба!");
        }
        System.out.println("***");
    }
}
