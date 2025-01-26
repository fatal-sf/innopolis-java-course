package homework6;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final String yes = "да";
        final String no = "нет";
        Market market = new Market("Пятерочка");
        Scanner scanner = new Scanner(System.in);
        boolean addProduct = true;
        boolean addPerson = true;
        System.out.println("Добавьте продукты");
        while (addProduct){
            System.out.println("Введите название продукта");
            String productName = scanner.nextLine();
            System.out.println("Введите цену продукта");
            int productPrice = scanner.nextInt();
            market.setProductInShelf(new Product(productName,productPrice));
            System.out.println("Добавить еще? Да/Нет");
            scanner.nextLine();
            switch (scanner.nextLine().toLowerCase()){
                case yes:
                    break;
                case no:
                    addProduct = false;
                    break;
                default:
                    System.out.println("Только Да или Нет!");
            }
        }
        System.out.println("Добавьте покупателей");
        while (addPerson){
            System.out.println("Введите имя");
            String personName = scanner.nextLine();
            System.out.println("Введите количество денег");
            int personAmount = scanner.nextInt();
            market.setBuyers(new Person(personName,personAmount));
            System.out.println("Добавить еще? Да/Нет");
            scanner.nextLine();
            switch (scanner.nextLine().toLowerCase()){
                case yes:
                    break;
                case no:
                    addPerson = false;
                    break;
                default:
                    System.out.println("Только Да или Нет!");
            }
        }
        System.out.println(market.toString());
//        Product bread = new Product("Хлеб",40);
//        Product milk = new Product("Молоко",60);
//        Product cake = new Product("Торт",1000);
//        Product instantCoffee = new Product("Кофе растворимый",879);
//        Product butter = new Product("Масло",150);
//        Product [] products = {bread,milk,cake,instantCoffee,butter};
//        Market market = new Market("Четверочка");
//        market.setProductShelf(products);
//
//        Person paul = new Person("Павел Андреевич",10000);
//        Person ann = new Person("Анна Петровна",-1);
//        Person boris = new Person("Борис",100);
//
//        market.buyProduct(bread,paul);
//        market.buyProduct(milk,paul);
//        market.buyProduct(bread,boris);
//        market.buyProduct(bread,boris);
//        market.buyProduct(cake,boris);
//        market.buyProduct(milk,paul);
//        market.buyProduct(cake,paul);
//        System.out.println(paul.toString());
//        System.out.println(boris.toString());
    }
}
