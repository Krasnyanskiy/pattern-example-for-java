package ua.krasnyanskiy.pattern.mediator;

import ua.krasnyanskiy.pattern.mediator.model.User;

import java.util.Set;

/**
 * We use an abstract class in order to be able to use loose coupling such us:
 * <p/>
 * Mediator mediator = new MediatorImpl(...)
 * <p/>
 * At the same time a setter for initializing of users field must be available. But as you may know
 * an interface doesn't allow us to do stuff like this. It doesn't have any setters or getters at all.
 * To solve this problem we use an abstract class.
 * <p/>
 * A little bit more information about this class. It knows all about users. Also it contains partial
 * API for user's communication.
 */
public abstract class Mediator {
    protected Set<User> users;

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    // An interface for all users

    /**
     * Sends a message
     */
    public abstract void send(String msg, User user);
}
