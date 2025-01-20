package homework6;

import java.util.Objects;

public class Product {
    /*
    Характеристики Продукта: название и стоимость.
    Название продукта не может быть пустой строкой, оно должно быть.
     Стоимость продукта не может быть отрицательным числом.
     */
    private String name;
    private int price;

    public Product (String name, int price){
        if (name != null){
            this.name = name;
        } else {
            System.out.println("Название продукта не может быть пустой строкой.");
        }
        if (price > 0){
            this.price = price;
        } else {
            System.out.println("Стоимость продукта не может быть отрицательным числом.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0){
            this.price = price;
        } else {
            System.out.println("Стоимость продукта не может быть отрицательным числом.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
