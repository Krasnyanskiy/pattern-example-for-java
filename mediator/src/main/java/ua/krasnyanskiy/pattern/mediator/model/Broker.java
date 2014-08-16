package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public class Broker extends User {
    public Broker(Mediator mediator, String name, String message) {
        super(mediator, name, message);
    }

    @Override
    public void handle(String msg) {
        System.out.println(getName() + " has got a message: " + msg);
    }
}
