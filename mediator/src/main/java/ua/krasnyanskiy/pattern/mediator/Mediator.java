package ua.krasnyanskiy.pattern.mediator;

import java.util.Set;

/**
 * We use an abstract class in order to be able to use loose coupling such this:
 *
 *      Mediator mediator = new MediatorImpl(...)
 *
 * At the same time a setter for initializing of users field must be available. But as you may know
 * an interface doesn't allow us to do it. It doesn't have any setters or getters at all. To solve
 * this problem we use an abstract class.
 *
 * A little bit more things about this class. It knows all about all users. Also
 * this class contains almost all API for user's communication.
 */
public abstract class Mediator {
    protected Set<User> users;

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<User> getUsers() {
        return users;
    }

    // An interface for all users
    public abstract void send(String msg, User user);
}