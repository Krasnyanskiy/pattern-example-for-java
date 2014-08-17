package ua.krasnyanskiy.pattern.visitor.operation;

import ua.krasnyanskiy.pattern.visitor.element.user.PrivilegedUser;
import ua.krasnyanskiy.pattern.visitor.element.user.StandardUser;

/**
 * @author Alexander Krasnyanskiy
 */
public class UserCardNumberPrintingVisitor implements Visitor{
    @Override
    public void visit(PrivilegedUser user) {
        System.out.println(user.getCard().getCardNumber());
    }

    @Override
    public void visit(StandardUser user) {
        System.out.println("Sorry, but this operation unavailable for your kind of users!");
    }
}
