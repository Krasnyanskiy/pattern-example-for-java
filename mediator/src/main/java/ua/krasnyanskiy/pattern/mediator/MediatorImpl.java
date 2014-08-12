package ua.krasnyanskiy.pattern.mediator;

import ua.krasnyanskiy.pattern.mediator.model.User;
import ua.krasnyanskiy.pattern.mediator.model.special.PrivilegedUser;

/**
 * @author Alexander Krasnyanskiy
 */
public class MediatorImpl extends Mediator {

    @Override
    public void send(String msg, User user) {
        for (User u : users) {
            if (!u.equals(user) && user instanceof PrivilegedUser && u instanceof PrivilegedUser) { // security workaround
                ((PrivilegedUser) u).handleSecret(msg);
            } else if (!u.equals(user) && !(user instanceof PrivilegedUser)){ // we don't need to handle a message from ourselves
                u.handle(msg);
            }
        }
    }
}