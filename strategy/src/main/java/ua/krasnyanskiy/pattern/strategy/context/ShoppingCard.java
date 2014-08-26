package ua.krasnyanskiy.pattern.strategy.context;

import ua.krasnyanskiy.pattern.strategy.algorithm.CreditCardPaymentStrategy;
import ua.krasnyanskiy.pattern.strategy.algorithm.PaymentStrategy;
import ua.krasnyanskiy.pattern.strategy.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class ShoppingCard {

    private PaymentStrategy strategy;
    private List<Product> products;

    public ShoppingCard() {
        products = new ArrayList<Product>();
        strategy = new CreditCardPaymentStrategy(); // default empty strategy fixme: need to setup
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public PaymentStrategy getStrategy() {
        return strategy;
    }

    public void updateStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculateTotal() {
        int sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

    public void pay() {
        int amount = calculateTotal();
        strategy.pay(amount);
    }
}
