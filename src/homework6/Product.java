package homework6;

import java.util.Objects;

public class Product {
    /*
    Характеристики Продукта: название и стоимость.
    Название продукта не может быть пустой строкой, оно должно быть.
     Стоимость продукта не может быть отрицательным числом.
     */
    //Название продукта
    private String name;
    //Стоимость продукта
    private int price;
    //Конструктор с параметрами название продукта (не может быть пустой строкой) и стоимость продукта (не может быть отрицательной)
    public Product (String name, int price){
        if (name != "" && name != null){
            this.name = name;
        } else {
            System.out.println("Название продукта не может быть пустой строкой.");
        }
        if (price >= 0){
            this.price = price;
        } else {
            System.out.println("Стоимость продукта не может быть отрицательным числом.");
        }
    }
    //Геттер поля название продукта
    public String getName() {
        return name;
    }
    //Геттер поля стоимость продукта
    public int getPrice() {
        return price;
    }
    //Сеттер поля стоимость продукта
    public void setPrice(int price) {
        if (price > 0){
            this.price = price;
        } else {
            System.out.println("Стоимость продукта не может быть отрицательным числом.");
        }
    }
    //Переопределение метода equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }
    //Переопределение метода hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
    //Переопределение метода toString()
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
