package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class User {

    protected Mediator mediator; // an API encapsulation for communication between users
    private String name;

    protected User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Sends a message
     */
    public void send(String msg) {
        mediator.send(msg, this); // simple delegation
    }

    /**
     * A method witch handle received message in unique style. This unique style with
     * unique logic is determined by each user.
     *
     * @param msg message
     */
    public abstract void handle(String msg);
}
