package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * A very simple User implementation.
 *
 * @author Alexander Krasnyanskiy
 */
public class SimpleUser extends User {
    public SimpleUser(Mediator mediator, String name) {
        super(mediator, name);
    }
}