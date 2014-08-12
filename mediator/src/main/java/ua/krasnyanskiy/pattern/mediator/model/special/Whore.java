package ua.krasnyanskiy.pattern.mediator.model.special;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public class Whore extends PrivilegedUser {

    public Whore(Mediator mediator, String name, String message) {
        super(mediator, name, message);
    }

    @Override
    public void handleSecret(String msg) {
        System.out.println(getName() + " has got a message: " + msg);
    }

    @Override
    public void handle(String msg) {
        System.out.println(getName() + " has got a message: " + msg);
    }
}
