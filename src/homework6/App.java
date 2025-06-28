package homework6;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //Список констант для работы приложения
        final String yes = "да";
        final String no = "нет";
        //Инициализирую сканер
        Scanner scanner = new Scanner(System.in);
        //Добавление магазина и небольшого описания
        Market market = new Market("Пятерочка");
        System.out.println("Добро пожаловать в магазин " + market.getName() + "! Для корректной работы магазина необходимо добавить продукты и покупателей");
        //Инициализирую переменные для работы циклов
        boolean addPerson = true;
        boolean addProduct = true;
        String buyProduct = "null";


        //Цикл для добавления продуктов на продуктовую полку магазина
        System.out.println("Добавьте продукты на продуктовую полку");
        //Нужно принимать покупателей одной строкой, между ними есть разделитель ";", по нему и должно происходить деление строки на разных покупателей, для этого используем метод класса String - split.
        //name,amount;name,amount;

        while (addProduct) {
            System.out.println("Добавьте продукты одной строкой вида: Гречка,150;Хлеб,50");
            String[] products = scanner.nextLine().split(";");
            for (int i = 0; i < products.length; i++) {
                String[] buff = products[i].split(",");
                if (buff.length == 2) {
                    if (!buff[0].equalsIgnoreCase("end") && !buff[1].equalsIgnoreCase("end") &&) {
                        market.setProductInShelf(new Product(buff[0], Integer.parseInt(buff[1])));
                    } else {
                        addProduct = false;
                        break;
                    }

                }
            }
        }


        /*while (addProduct){
            //Инициализируем переменную для хранения названия продукта
            String  productName = null;
            //Цикл для добавления названия продукта. Название продукта не может быть null или пустым.
            while (productName==null || productName.isEmpty()){
                System.out.println("Введите название продукта");
                 productName = scanner.nextLine();
            }
            System.out.println("Укажите стоимость продукта");
            //Инициализируем переменную для хранения стоимости продукта
            int productPrice = scanner.nextInt();
            //Добавляем продукт на полку магазина
            market.setProductInShelf(new Product(productName,productPrice));
            //Предоставляем пользователю возможность добавить еще или выйти из цикла
            System.out.println("Добавить еще? Да/Нет");
            //Очищаем предыдущий ввод
            scanner.nextLine();
            //Обрабатываем полученный ответ
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
        */
        //Цикл для добавления покупателей в магазин
        System.out.println("Добавьте покупателей");
        loop:
        while (addPerson) {
            //Инициализируем переменную для хранения введеного имени покупателя
            String personName = null;
            //Цикл для ввода имени покупателя. Имя не должно быть null или пустым.
            while (personName == null || personName.isEmpty()) {
                System.out.println("Введите имя");
                personName = scanner.nextLine();
            }
            System.out.println("Введите количество денег");
            //Инициализируем переменную для хранения, считываем введенную цифру
            int personAmount = scanner.nextInt();
            //Добавляем покупателя в список покупателей магазина
            market.setBuyers(new Person(personName, personAmount));
            //Предоставляем пользователю возможность добавить еще или выйти из цикла
            System.out.println("Добавить еще? Да/Нет");
            //Очищаем предыдущий ввод
            scanner.nextLine();
            //Обрабатываем полученный ответ
            switch (scanner.nextLine().toLowerCase()) {
                case yes:
                    break;
                case no:
                    addPerson = false;
                    break loop;
                default:
                    System.out.println("Только Да или Нет!");
            }
        }
        //Цикл для совершения покупок в магазине
        while (!buyProduct.equalsIgnoreCase("end")) {
            //Отображаем как подсказку список покупателей и продуктовую полку
            System.out.println("Выберите покупателя: " + market.getBuyersName() + " и продукт:" + market.getProductNameFromShelf());
            //Инициализируем переменную для хранения введеного имени покупателя
            String buyerName = null;
            //Цикл для ввода имени покупателя. Введенное имя не должно быть null, пустым и должно присутствовать в списке покупателей
            while (buyerName == null || buyerName.isEmpty() || market.getBuyerByName(buyerName) == null) {
                System.out.println("Введите имя покупателя из списка");
                buyerName = scanner.nextLine();
            }
            //Инициализируем переменную для хранения названия продукта
            String buyProductName = null;
            //Цикл для ввода названия продукта. Введенное название не должно быть null, пустым и должно присутствовать на продуктовой полке
            while (buyProductName == null || buyProductName.isEmpty() || market.getProductFromShelfByname(buyProductName) == null) {
                System.out.println("Введите название продукта из списка");
                buyProductName = scanner.nextLine();
            }
            //Совершаем покупку
            market.buyProduct(market.getProductFromShelfByname(buyProductName), market.getBuyerByName(buyerName));
            //Предлагаем пользователю возможность совершить покупку еще раз либо завершить покупки.
            System.out.println("Для продолжения покупок нажмите ENTER, для остановки введите в коносли \"end\"");
            //Считываем выбор пользователя
            buyProduct = scanner.nextLine();
        }
        //Выводим список покупателей и их покупки
        for (Person person : market.getBuyers()) {
            System.out.print(person.getName() + " - ");
            if (person.getProductsNameFromBasket(person) != null) {
                System.out.print(person.getProductsNameFromBasket(person));
                System.out.println();

            } else {
                System.out.print("Ничего не куплено.");
                System.out.println();
            }
        }
    }
}
