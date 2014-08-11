package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class User {

    private Mediator mediator; // an API for communication between users
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
     * Message handler
     */
    public void handle(String msg){
        mediator.handle(msg, this); // simple delegation
    }
}
