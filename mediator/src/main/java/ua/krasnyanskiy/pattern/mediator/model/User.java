package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class User {

    protected Mediator mediator; // an API encapsulation for communication between users
    private String name;
    private String message;

    protected User(Mediator mediator, String name, String message) {
        this.mediator = mediator;
        this.name = name;
        this.message = message;
    }

    public String getMessage() {
        return message;
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
     * A method which handle received message in unique style. This unique style with
     * unique logic is determined by each user.
     *
     * @param msg message
     */
    public abstract void handle(String msg);
}
