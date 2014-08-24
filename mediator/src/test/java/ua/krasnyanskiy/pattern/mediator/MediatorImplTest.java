package ua.krasnyanskiy.pattern.mediator;

import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.Test;
import ua.krasnyanskiy.pattern.mediator.model.Broker;
import ua.krasnyanskiy.pattern.mediator.model.Consumer;
import ua.krasnyanskiy.pattern.mediator.model.Producer;
import ua.krasnyanskiy.pattern.mediator.model.User;
import ua.krasnyanskiy.pattern.mediator.model.special.Bartender;
import ua.krasnyanskiy.pattern.mediator.model.special.Whore;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Unit tests for {@link MediatorImpl}
 *
 * @author Alexander Krasnyanskiy
 */
public class MediatorImplTest extends PowerMockTestCase {

    @Test
    /**
     * for {@link MediatorImpl#send(String, User)}
     */
    public void should_invoke_handle_method_for_all_non_privileged_users_of_mediator() {

        /* Given */
        final Mediator mediator = new MediatorImpl();

        final Consumer consumer = spy(new Consumer(mediator, "John", "Hi form John!"));
        final Producer producer = spy(new Producer(mediator, "Bill", "Hi form Bill!"));

        doNothing().when(consumer).handle(anyString());
        doNothing().when(producer).handle(anyString());

        Set<User> users = new HashSet<User>() {{
            add(consumer);
            add(producer);
        }};

        mediator.setUsers(users);

        /* When */
        producer.send(producer.getMessage());

        /* Than */
        verify(consumer, times(1)).handle("Hi form Bill!");
    }

    @Test
    /**
     * for {@link MediatorImpl#send(String, User)}
     */
    public void should_invoke_handleSecret_method_for_all_privileged_users_of_mediator() {

        /* Given */
        final Mediator mediator = new MediatorImpl();

        final Broker broker = spy(new Broker(mediator, "John", "Hi form John!"));
        final Whore whore = spy(new Whore(mediator, "Sasha Gray", "Hi from Sasha!"));
        final Bartender bartender = spy(new Bartender(mediator, "Tom Cruise", "Hi from Tom!"));

        doNothing().when(broker).handle(anyString());
        doNothing().when(whore).handle(anyString());
        doNothing().when(bartender).handle(anyString());

        doNothing().when(whore).handleSecret(anyString());
        doNothing().when(bartender).handleSecret(anyString());

        Set<User> users = new HashSet<User>() {{
            add(broker);
            add(whore);
            add(bartender);
        }};

        mediator.setUsers(users);

        /* When */
        whore.send(whore.getMessage());
        broker.send(broker.getMessage());

        /* Than */
        verify(bartender, times(1)).handleSecret("Hi from Sasha!");
        verify(whore, times(1)).handle("Hi form John!");
        verify(bartender, times(1)).handle("Hi form John!");
    }
}


