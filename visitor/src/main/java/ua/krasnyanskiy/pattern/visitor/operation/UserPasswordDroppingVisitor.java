package ua.krasnyanskiy.pattern.visitor.operation;

import ua.krasnyanskiy.pattern.visitor.element.user.PrivilegedUser;
import ua.krasnyanskiy.pattern.visitor.element.user.StandardUser;

/**
 * @author Alexander Krasnyanskiy
 */
public class UserPasswordDroppingVisitor implements Visitor {

    @Override
    public void visit(PrivilegedUser user) {
        user.setPassword("veryLongAndHighProtectedDefaultPassword");
    }

    @Override
    public void visit(StandardUser user) {
        user.setPassword("abc");
    }
}
