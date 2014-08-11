package ua.krasnyanskiy.pattern.mediator.model;

import ua.krasnyanskiy.pattern.mediator.Mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class User {

    private Mediator mediator;
    private String name;    

    protected User(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Sends a message.
     */
    public void send(String msg) {
        mediator.send(msg, this); // Simple delegation.
    }

    /**
     * Message handler.
     */
    public void handle(String msg){
        mediator.handle(msg, this); // Simple delegation.
    }
}
