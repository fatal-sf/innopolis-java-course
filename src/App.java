import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TV tv1 = new TV("White",false);
        TV tv2 = new TV();
        System.out.println(tv1.toString());
        System.out.println(tv2.toString());
        System.out.println("Выберите цвет:");
        String color = scanner.nextLine();
        System.out.println("Нужен ли вай фай модуль? Введите 0 - если не нужен и 1 - если нужен:");
        boolean wifiModule = scanner.hasNextBoolean();
        TV tv3 = new TV (color, wifiModule);
        System.out.println(tv3.toString());
        System.out.println("");
        System.out.println("******************************************");
        System.out.println("Взаимодействие с телевизором");
        System.out.println("Включить телевизор? 0 - не включай, 1 - включи, 3 включи конкретный канал");
        scanner.nextLine();
        int action = scanner.nextInt();
        int channel = 0;
        switch (action){
            case 0 -> {
                System.out.println("Не очень то и хотелось...");
            }
            case 1 -> {
                tv3.powerOn();
            }
            case 3 -> {
                System.out.println("Введи канал:");
                channel = scanner.nextInt();
                tv3.powerOn(channel);
            }
        }
        System.out.println("Выключить телевизор? 0 - нет, 1 - да");
         action = scanner.nextInt();
         switch (action){
             case 0 -> {
                 tv3.viewChannel(tv3.getCurrentChannel());
             }
             case 1 -> {
                 tv3.powerOff();
             }
             default -> {
                 System.out.println("Только 0 или 1, определись уже!");
             }
         }
    }
}
