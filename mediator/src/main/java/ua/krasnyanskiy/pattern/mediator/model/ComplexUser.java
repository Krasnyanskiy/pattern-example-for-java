package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public class ComplexUser extends User {
    public ComplexUser(Mediator mediator, String name) {
        super(mediator, name);
    }
}