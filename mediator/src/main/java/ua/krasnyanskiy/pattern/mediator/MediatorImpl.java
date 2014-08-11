package ua.krasnyanskiy.pattern.mediator;

import ua.krasnyanskiy.pattern.mediator.model.User;

/**
 * @author Alexander Krasnyanskiy
 */
public class MediatorImpl extends Mediator {

    @Override
    public void send(String msg, User user) {
        for (User u : users) {
            if (!u.equals(user)) { // we don't need to handle a message from ourselves
                u.handle(msg);
            }
        }
    }

    @Override
    public void handle(String msg, User user) {
        System.out.println(user.getName() + " has got a message! It is [" + msg + "]");
    }
}