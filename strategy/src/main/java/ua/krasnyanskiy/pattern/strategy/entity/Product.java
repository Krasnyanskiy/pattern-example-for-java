package ua.krasnyanskiy.pattern.strategy.entity;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class Product {

    private Integer price;
    private String name;

    public Product(Integer price, String name) {
        this.price = price;
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
