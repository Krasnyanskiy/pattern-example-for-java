package ua.krasnyanskiy.pattern.mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public class ComplexUser extends User {

    public ComplexUser(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void handle(String msg) {
        System.out.println("I (" + getName() + ") received a message: " + msg);
    }
}