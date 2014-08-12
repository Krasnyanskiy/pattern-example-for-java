package ua.krasnyanskiy.pattern.mediator.model.special;

import ua.krasnyanskiy.pattern.mediator.Mediator;
import ua.krasnyanskiy.pattern.mediator.model.User;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class PrivilegedUser extends User {
    protected PrivilegedUser(Mediator mediator, String name, String message) {
        super(mediator, name, message);
    }

    public abstract void handleSecret(String msg);
}
