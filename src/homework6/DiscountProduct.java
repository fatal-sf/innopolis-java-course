package homework6;

public class DiscountProduct extends Product{
    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public DiscountProduct(String name, int price, int discount) {
        super(name, price);
        this.discount = discount;
    }

    public int getPrice() {
        return (1-getDiscount()/100)-super.getPrice();
    }

}
