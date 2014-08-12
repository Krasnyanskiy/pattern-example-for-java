package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public class Producer extends User {
    public Producer(Mediator mediator, String name, String message) {
        super(mediator, name, message);
    }

    @Override
    public void handle(String msg) {
        System.out.println(getName() + " has got a message: " + msg);
    }
}