package ua.krasnyanskiy.pattern.mediator;

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

    public void setName(String name) {
        this.name = name;
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
