package ua.krasnyanskiy.pattern.strategy.runner;

import ua.krasnyanskiy.pattern.strategy.algorithm.CreditCardPaymentStrategy;
import ua.krasnyanskiy.pattern.strategy.algorithm.PayPalPaymentStrategy;
import ua.krasnyanskiy.pattern.strategy.entity.ShavingFoam;
import ua.krasnyanskiy.pattern.strategy.entity.ShoppingCard;
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

        card.pay(new CreditCardPaymentStrategy("John", "1234567890987654", "342", "10/23/19"));
        card.pay(new PayPalPaymentStrategy("john@gmail.com", "qwerty"));

    }
}
