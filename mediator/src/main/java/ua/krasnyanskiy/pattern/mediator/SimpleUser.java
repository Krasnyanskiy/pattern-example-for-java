package ua.krasnyanskiy.pattern.mediator;

/**
 * A very simple User implementation.
 *
 * @author Alexander Krasnyanskiy
 */
public class SimpleUser extends User {

    public SimpleUser(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void handle(String msg) {
        System.out.println(getName() + " has got a message! It is [" + msg + "]");
    }
}