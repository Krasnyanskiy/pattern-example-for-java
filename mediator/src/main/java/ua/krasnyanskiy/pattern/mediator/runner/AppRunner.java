package ua.krasnyanskiy.pattern.mediator.runner;

import ua.krasnyanskiy.pattern.mediator.model.Broker;
import ua.krasnyanskiy.pattern.mediator.model.Producer;
import ua.krasnyanskiy.pattern.mediator.Mediator;
import ua.krasnyanskiy.pattern.mediator.MediatorImpl;
import ua.krasnyanskiy.pattern.mediator.model.Consumer;
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
            add(new Consumer(mediator, "Fred The Consumer"));
            add(new Producer(mediator, "Mike The Producer"));
            add(new Broker(mediator, "Fill The Broker"));
        }};

        mediator.setUsers(users);

        for (User user : users) {
            user.send("Hi from " + user.getName() + "!");
        }
    }
}