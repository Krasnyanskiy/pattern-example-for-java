package ua.krasnyanskiy.pattern.strategy.runner;

import ua.krasnyanskiy.pattern.strategy.algorithm.CreditCardPaymentStrategy;
import ua.krasnyanskiy.pattern.strategy.algorithm.PayPalPaymentStrategy;
import ua.krasnyanskiy.pattern.strategy.context.ShoppingCard;
import ua.krasnyanskiy.pattern.strategy.entity.ShavingFoam;
import ua.krasnyanskiy.pattern.strategy.entity.Toy;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {
    public static void main(String[] args) {

        Toy miniBarbie = new Toy(100, "Barbie");
        ShavingFoam gilletteShavingFoam = new ShavingFoam(4, "Gillette");

        ShoppingCard card = new ShoppingCard();
        card.addProduct(miniBarbie);
        card.addProduct(gilletteShavingFoam);

        CreditCardPaymentStrategy strategy = (CreditCardPaymentStrategy) card.getStrategy();
        strategy.setName("John");
        strategy.setName("1234567890987654");
        strategy.setName("342");
        strategy.setName("10/23/19");
        card.pay();

        card.updateStrategy(new PayPalPaymentStrategy("john@gmail.com", "qwerty"));
        card.pay();
    }
}
