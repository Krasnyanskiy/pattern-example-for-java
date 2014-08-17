package ua.krasnyanskiy.pattern.visitor.element.user;

import ua.krasnyanskiy.pattern.visitor.element.user.attribute.CreditCard;
import ua.krasnyanskiy.pattern.visitor.operation.Visitor;

/**
 * @author Alexander Krasnyanskiy
 */
public class PrivilegedUser extends User {

    private CreditCard card;

    public CreditCard getCard() {
        return card;
    }

    public void setCard(CreditCard card) {
        this.card = card;
    }

    @Override
    public void perform(Visitor operation) {
        operation.visit(this);
    }
}
