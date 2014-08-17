package ua.krasnyanskiy.pattern.visitor.element.user;

import ua.krasnyanskiy.pattern.visitor.operation.Visitor;

/**
 * @author Alexander Krasnyanskiy
 */
public class StandardUser extends User{

    @Override
    public void perform(Visitor operation) {
        operation.visit(this);
    }
}
