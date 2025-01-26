package homework6;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    /*
    Характеристики Покупателя: имя, сумма денег и  пакет с продуктами(массив объектов типа Продукт). Имя не может быть пустой строкой.
    Деньги не могут быть отрицательным числом.Если Покупатель может позволить себе Продукт, то Продукт добавляетсяв пакет. Если у Покупателя
     недостаточно денег, то добавление не происходит.
     */
    //Имя покупателя
    private String name;
    //Сумма денег
    private int amount;
    //Пакет с продуктами
    private Product [] productsBasket;
    //Конструктор с параметрами имя покупателя (не может быть пустой строкой) и сумма денег(не может быть отрицательным числом).
    public Person(String name, int amount){
        if (name!=""){
            this.name = name;
        } else {
            System.out.println("Имя не может быть пустой строкой.");
        }
       this.setAmount(amount);
    }
    //Геттер поля имя покупателя
    public String getName() {
        return name;
    }
    //Геттер поля сумма денег покупателя
    public int getAmount() {
        return amount;
    }
    //Сеттер поля сумма денег покупателя
    public void setAmount(int amount) {
       if (amount >= 0){
           this.amount = amount;
       } else{
           this.amount = amount;
           System.out.println("Деньги не могут быть отрицательными");
       }
    }
    //Геттер поля Пакет с продуктами
    public Product[] getProductsBasket() {
        return productsBasket;
    }
    //Метод возвращает продукт из пакета по его индексу
    public Product getProductFromBasket(int index){
        return this.productsBasket[index];
    }
    //Метод, который возвращает по покупателю названия продуктов из его пакета одной строкой
    public String getProductsNameFromBasket(Person person){
        if(productsBasket!=null){
            StringBuilder buff = new StringBuilder();
            for (int i = 0; i <= productsBasket.length-2; i++){
                buff.append(getProductFromBasket(i).getName()+", ");
            }
            buff.append(getProductFromBasket(productsBasket.length-1).getName());
            return buff.toString();
        }
        return null;
    }
    //Сеттер для пакета с продуктами
    public void setProductsBasket(Product[] productsBasket) {
        this.productsBasket = productsBasket;
    }
    //Переопределение метода toString()
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", productsBasket=" + Arrays.toString(productsBasket) +
                '}';
    }
    //Переопределение equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return amount == person.amount && Objects.equals(name, person.name) && Objects.deepEquals(productsBasket, person.productsBasket);
    }
    //Переопределение метода hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(name, amount, Arrays.hashCode(productsBasket));
    }
}
