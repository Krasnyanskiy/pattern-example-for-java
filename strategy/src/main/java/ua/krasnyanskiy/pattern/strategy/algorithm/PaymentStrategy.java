package ua.krasnyanskiy.pattern.strategy.algorithm;

/**
 * This class defines an interface of algorithm.
 *
 * @author Alexander Krasnyanskiy
 */
public interface PaymentStrategy {
    void pay(int amount);
}
