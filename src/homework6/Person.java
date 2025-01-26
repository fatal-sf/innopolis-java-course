package homework6;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    /*
    Характеристики Покупателя: имя, сумма денег и  пакет с продуктами(массив объектов типа Продукт). Имя не может быть пустой строкой.
    Деньги не могут быть отрицательным числом.Если Покупатель может позволить себе Продукт, то Продукт добавляетсяв пакет. Если у Покупателя
     недостаточно денег, то добавление не происходит.
     */
    private String name;
    private int amount;
    private Product [] productsBasket;

    public Person(String name, int amount){
        if (name!=""){
            this.name = name;
        } else {
            System.out.println("Имя не может быть пустой строкой.");
        }
       this.setAmount(amount);
    }

    public String getName() {
        return name;

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
       if (amount >= 0){
           this.amount = amount;
       } else{
           System.out.println("Деньги не могут быть отрицательными");
       }

    }

    public Product[] getProductsBasket() {
        return productsBasket;
    }

    public Product getProductFromBasket(int index){
        return this.productsBasket[index];
    }
    public String[] getProductsNameFromBasket(Person person){
        if(productsBasket!=null){
            String[] buff = new String[productsBasket.length];
            for (int i = 0; i < buff.length; i++){
                buff[i] = getProductFromBasket(i).getName();
            }
            return buff;
        }
        return null;

    }

    public void setProductsBasket(Product[] productsBasket) {
        this.productsBasket = productsBasket;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", productsBasket=" + Arrays.toString(productsBasket) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return amount == person.amount && Objects.equals(name, person.name) && Objects.deepEquals(productsBasket, person.productsBasket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, Arrays.hashCode(productsBasket));
    }
}
