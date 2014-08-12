package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * A very simple User implementation
 *
 * @author Alexander Krasnyanskiy
 */
public class Consumer extends User {
    public Consumer(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void handle(String msg) {
        System.out.println(getName() + " has got a message! It is [" + msg + "]");
    }
}