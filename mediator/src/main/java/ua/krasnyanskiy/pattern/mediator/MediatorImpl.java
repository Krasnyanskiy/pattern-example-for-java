package ua.krasnyanskiy.pattern.mediator;

/**
 * @author Alexander Krasnyanskiy
 */
public class MediatorImpl extends Mediator {

    @Override
    public void send(String msg, User user) {
        for (User u : users) {
            if (!u.equals(user)) { // we don't ween to handle a message from ourselves
                u.handle(msg);
            }
        }
    }
}