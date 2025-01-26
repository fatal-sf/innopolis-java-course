package homework6;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final String yes = "да";
        final String no = "нет";
        final String go = "еще";
        final String end = "end";
        Market market = new Market("Пятерочка");
        Scanner scanner = new Scanner(System.in);

        boolean addPerson = true;
        boolean addProduct = true;

        loop:
        while (addProduct){
            String  productName = null;
            while (productName==null || productName.isEmpty()){
                System.out.println("Введите название продукта");
                 productName = scanner.nextLine();
            }
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
                    break loop;
                default:
                    System.out.println("Только Да или Нет!");
            }
        }
        System.out.println("Добавьте покупателей");
        loop:
        while (addPerson){
            String personName=null;
            while (personName==null || personName.isEmpty()){
                System.out.println("Введите имя");
                personName = scanner.nextLine();
            }
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
                    break loop;
                default:
                    System.out.println("Только Да или Нет!");
            }
        }
        String buyProduct = "null";
        while (!buyProduct.equalsIgnoreCase("end")){
            System.out.println("Выберите покупателя: " + Arrays.toString(market.getBuyers()) + " и продукт:" + Arrays.toString(market.getProductShelf()));
            String buyerName=null;
            while (buyerName==null || buyerName.isEmpty() || market.getBuyerByName(buyerName)==null){
                System.out.println("Введите имя покупателя из списка");
                buyerName = scanner.nextLine();
            }
            String buyProductName=null;
            while (buyProductName==null || buyProductName.isEmpty() || market.getProductFromShelfByname(buyProductName)== null){
                System.out.println("Введите название продукта из списка");
                buyProductName = scanner.nextLine();
            }
            market.buyProduct(market.getProductFromShelfByname(buyProductName),market.getBuyerByName(buyerName));
            System.out.println("Для продолжения покупок нажмите ENTER, для остановки введите в коносли \"end\"");
            buyProduct = scanner.nextLine();

        }

        for (Person person: market.getBuyers()){
            System.out.print(person.getName() + " - ");
            if (person.getProductsNameFromBasket(person) != null){
                    System.out.print(Arrays.toString(person.getProductsNameFromBasket(person)));
                System.out.println();

            } else{
                System.out.print("Ничего не куплено.");
                System.out.println();
            }
        }

    }
}
