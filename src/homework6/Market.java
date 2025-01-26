package homework6;

import java.util.Arrays;
import java.util.Objects;

public class Market {

    //Реализовал вспомогательный класс Магазин с полями: Название магазина, продуктовая полка, покупатели.

    //Название магазина
    private String name;
    //продуктовая полка
    private Product[] productShelf;
    //покупатели
    private Person[] buyers;
    //Конструктор с параметром название магазина
    public Market (String name){
        this.name = name;
    }
    //Геттер названия магазина
    public String getName(){
        return this.name;
    }
    //Геттер поля покупатели
    public Person[] getBuyers() {
        return buyers;
    }
    //Метод для получения покупателя по индексу
    public Person getBuyersByIndex(int i) {
        return buyers[i];
    }
    //Метод для получения имен покупателей одной строкой
    public String getBuyersName(){
        if(buyers!=null){
            int length = buyers.length;
            StringBuilder buff = new StringBuilder();
            for (int i = 0; i <= length-2; i++){
                buff.append(getBuyersByIndex(i).getName()+", ");
            }
            buff.append(getBuyersByIndex(length-1).getName());
            return buff.toString();
        }
        return null;
    }
    //Метод для получения покупателя по его имени
    public Person getBuyerByName (String name){
        for(Person buyer:buyers){
            if (buyer.getName().equals(name)){
                return buyer;
            }
        }
        return null;
    }
    //Метод для добавления покупателей
    public void setBuyers (Person person){
        if(person.getAmount()>=0){
            if(getBuyers() == null){
                buyers = new Person[]{person};
            } else {
                Person [] buff = new Person[buyers.length+1];
                for (int i = 0; i < buyers.length;i++){
                    buff[i] = buyers[i];
                }
                buff[buff.length-1] = person;
                buyers = buff;
            }
        } else {
            System.out.println(person.getName() + " не добавлен в список покупателей, т.к. он должник!");
        }
    }
    //Метод для добавления продукта на продуктовую полку
    public void setProductInShelf(Product product){
        if(product.getPrice()>0){
            if(getProductShelf() == null){
                productShelf = new Product[]{product};
            } else {
                Product [] buff = new Product [productShelf.length+1];
                for (int i = 0; i < productShelf.length;i++){
                    buff[i]=productShelf[i];
                }
                buff[buff.length-1]=product;
                productShelf = buff;
            }
        } else {
            System.out.println(product.getName() + " не добавлен на продуктовую полку, т.к. отсутствует ценник.");
        }
    }
    //Метод для получения продукта с продуктовой полки по имени
    public Product getProductFromShelfByname(String name){
        for(Product product:productShelf){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }
    //Метод для получения продуктовой полки
    public Product[] getProductShelf() {
        return productShelf;
    }
    //Метод для получения продукта с продуктовой полки по индексу
    public Product getProductsFromShelfByIndex(int i) {
        return productShelf[i];
    }
    //Метод для получения названий продуктов с продуктовой полки одной строкой
    public String getProductNameFromShelf(){
        if(productShelf!=null){
            int length = productShelf.length;
            StringBuilder buff = new StringBuilder();
            for (int i = 0; i <= length-2; i++){
                buff.append(getProductsFromShelfByIndex(i).getName()+", ");
            }
            buff.append(getProductsFromShelfByIndex(length-1).getName());
            return buff.toString();
        }
        return null;
    }
    //Метод для покупки продукта(добавления продукта в пакет покупателю)
    public void buyProduct (Product product, Person person){
        if(person.getAmount() - product.getPrice() >=0){
            person.setAmount(person.getAmount() - product.getPrice());
            if (person.getProductsBasket() != null){
                int length = person.getProductsBasket().length;
                Product [] buff = new Product[length+1];
               for (int i = 0; i < length;i++){
                   buff[i]=person.getProductFromBasket(i);
               }
               buff[buff.length-1]=product;
                person.setProductsBasket(buff);
            } else {
                Product [] buff = {product};
                person.setProductsBasket(buff);
            }
            System.out.println(person.getName() + " купил (-а) " + product.getName());
        } else {
            System.out.println(person.getName() + " не может позволить себе " + product.getName());
        }
    }
    //Переопределение метода equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market market = (Market) o;
        return Objects.equals(name, market.name) && Objects.deepEquals(productShelf, market.productShelf);
    }
    //Переопределение метода hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(productShelf));
    }
    //Переопределение метода toString()
    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", productShelf=" + Arrays.toString(productShelf) +
                ", buyers=" + Arrays.toString(buyers) +
                '}';
    }
}
