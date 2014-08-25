package ua.krasnyanskiy.pattern.strategy.entity;

import ua.krasnyanskiy.pattern.strategy.algorithm.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class ShoppingCard {
    private List<Product> products;

    public ShoppingCard() {
        products = new ArrayList<Product>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void deleteProduct(Product product){
        products.remove(product);
    }

    public int calculateTotal() {
        int sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void pay(PaymentStrategy strategy) {
        int amount = calculateTotal();
        strategy.pay(amount);
    }
}
