package ua.krasnyanskiy.pattern.visitor.operation;

import ua.krasnyanskiy.pattern.visitor.element.user.PrivilegedUser;
import ua.krasnyanskiy.pattern.visitor.element.user.StandardUser;

/**
 * @author Alexander Krasnyanskiy
 */
public interface Visitor {
    void visit(PrivilegedUser user);
    void visit(StandardUser user);
}
