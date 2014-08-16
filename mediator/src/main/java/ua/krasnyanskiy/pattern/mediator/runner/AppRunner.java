package ua.krasnyanskiy.pattern.mediator.runner;

import ua.krasnyanskiy.pattern.mediator.Mediator;
import ua.krasnyanskiy.pattern.mediator.MediatorImpl;
import ua.krasnyanskiy.pattern.mediator.model.Broker;
import ua.krasnyanskiy.pattern.mediator.model.Consumer;
import ua.krasnyanskiy.pattern.mediator.model.Producer;
import ua.krasnyanskiy.pattern.mediator.model.User;
import ua.krasnyanskiy.pattern.mediator.model.special.Bartender;
import ua.krasnyanskiy.pattern.mediator.model.special.Whore;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alexander Krasnyanskiy
 */
// todo: we also can add functionality for single user adding
public class AppRunner {
    public static void main(String[] args) {

        final Mediator mediator = new MediatorImpl();

        Set<User> users = new HashSet<User>() {{

            // Ordinary guys
            add(new Consumer(mediator, "Fred The Consumer", "Yeah! I'm buying, give me two!"));
            add(new Producer(mediator, "Mike The Producer", "Want some role?"));
            add(new Broker(mediator, "Fill The Broker", "I'm a rogue"));

            // Special guests
            add(new Whore(mediator, "Sasha Gray The DeepThroat", "Only for a 5 bucks!"));
            add(new Bartender(mediator, "Bob The Master", "Tequila for a dirty lady!"));
        }};

        mediator.setUsers(users);

        for (User user : users) {
            user.send("'" + user.getMessage() + ",' says " + user.getName());
        }
    }
}