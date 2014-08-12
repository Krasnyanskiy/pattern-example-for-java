package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public class Whore extends PrivilegedUser {

    public Whore(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void handle(String msg) {
        System.out.println(getName() + " has got a message! It is [" + msg + "]");
    }
}
