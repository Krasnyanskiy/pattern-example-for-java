package ua.krasnyanskiy.pattern.visitor.element.user.attribute;

import java.math.BigDecimal;

/**
 * @author Alexander Krasnyanskiy
 */
public class CreditCard {

    BigDecimal cardNumber;

    public CreditCard(long cardNumber) {
        this.cardNumber = new BigDecimal(cardNumber);
    }

    public BigDecimal getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigDecimal cardNumber) {
        this.cardNumber = cardNumber;
    }
}
