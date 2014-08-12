package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class PrivilegedUser extends User {
    protected PrivilegedUser(Mediator mediator, String name) {
        super(mediator, name);
    }

    // Privileged API
    public int sendSpecialMessage (String msg){
        return mediator.sendSpecialMessage(msg, this);
    }
}
