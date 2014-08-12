package ua.krasnyanskiy.pattern.mediator;

import ua.krasnyanskiy.pattern.mediator.model.PrivilegedUser;
import ua.krasnyanskiy.pattern.mediator.model.User;

/**
 * @author Alexander Krasnyanskiy
 */
public class MediatorImpl extends Mediator {

    private final int SECRET_CODE = 100500;

    @Override
    public void send(String msg, User user) {
        for (User u : users) {
            if (!u.equals(user)) { // we don't need to handle a message from ourselves
                u.handle(msg);
            }
        }
    }

    @Override
    public int sendSpecialMessage(String specialMessage, PrivilegedUser user) {
        for (User u : users) {
            if (!u.equals(user) && u instanceof PrivilegedUser) { /** see comment for {@link MediatorImpl#send(String, User)} method **/
                u.handle(specialMessage);
            }
        }
        return SECRET_CODE;
    }
}