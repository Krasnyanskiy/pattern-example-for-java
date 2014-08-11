package ua.krasnyanskiy.pattern.mediator.runner;

import ua.krasnyanskiy.pattern.mediator.model.ComplexUser;
import ua.krasnyanskiy.pattern.mediator.Mediator;
import ua.krasnyanskiy.pattern.mediator.MediatorImpl;
import ua.krasnyanskiy.pattern.mediator.model.SimpleUser;
import ua.krasnyanskiy.pattern.mediator.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {
    public static void main(String[] args) {

        final Mediator mediator = new MediatorImpl();

        Set<User> users = new HashSet<User>() {{
            add(new SimpleUser(mediator, "Fred"));
            add(new ComplexUser(mediator, "Boris"));
        }};

        mediator.setUsers(users);

        for (User user : users) {
            user.send("Hi from " + user.getName() + "!");
        }
    }
}