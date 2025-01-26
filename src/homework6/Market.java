package homework6;

import java.util.Arrays;
import java.util.Objects;

public class Market {
    private String name;
    private Product[] productShelf;
    private Person[] buyers;
    public Market (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person[] getBuyers() {
        return buyers;
    }
    public Person getBuyerByName (String name){
        for(Person buyer:buyers){
            if (buyer.getName().equals(name)){
                return buyer;
            }
        }
        return null;
    }

    public void setBuyers (Person person){
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
    }
    public void setProductInShelf(Product product){
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
    }

    public Product getProductFromShelfByname(String name){
        for(Product product:productShelf){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public Product[] getProductShelf() {
        return productShelf;
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market market = (Market) o;
        return Objects.equals(name, market.name) && Objects.deepEquals(productShelf, market.productShelf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(productShelf));
    }

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", productShelf=" + Arrays.toString(productShelf) +
                ", buyers=" + Arrays.toString(buyers) +
                '}';
    }
}
