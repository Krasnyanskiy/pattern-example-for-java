package ua.krasnyanskiy.pattern.observer.subject;

import org.testng.annotations.Test;
import ua.krasnyanskiy.pattern.observer.object.Businessman;
import ua.krasnyanskiy.pattern.observer.object.Client;
import ua.krasnyanskiy.pattern.observer.object.Housewife;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.util.reflection.Whitebox.getInternalState;
import static org.mockito.internal.util.reflection.Whitebox.setInternalState;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class PostManTest {

    @Test
    /**
     * for {@link PostMan#registerClient(Client)}
     */
    @SuppressWarnings("unchecked")
    public void should_add_new_client_into_messenger_collection() {

        /* Given */
        PostMan postman = new PostMan();

        /* When */
        new Businessman("Bob", postman);

        /* Than */
        List<Client> retrievedClients = (List<Client>) getInternalState(postman, "clients");
        assertTrue(retrievedClients.size() == 1);
    }

    @Test
    /**
     * for {@link PostMan#setNews(String)}
     */
    public void should_add_news_notify_all_subscribers() {

        /* Given */
        PostMan postmanSpy = spy(new PostMan());
        doNothing().when(postmanSpy).notifyClients();
        new Businessman("Bob", postmanSpy);

        /* When */
        postmanSpy.setNews("Macy's settles racial profiling cases.");

        /* Than */
        verify(postmanSpy, times(1)).notifyClients();
        String retrievedNews = (String) getInternalState(postmanSpy, "news");
        assertNotNull(retrievedNews);
        assertEquals(retrievedNews, "Macy's settles racial profiling cases.");
    }

    @Test
    /**
     * for {@link PostMan#notifyClients()}
     */
    public void should_invoke_method_get_for_every_client() {

        /* Given */
        PostMan postman = new PostMan();

        final Client john = spy(new Businessman("John", postman));
        final Client angelina = spy(new Housewife("Angelina", postman));

        List<Client> clientsSpy = new ArrayList<Client>() {{
            add(john);
            add(angelina);
        }};

        setInternalState(postman, "news", "Macy's settles racial profiling cases.");
        setInternalState(postman, "clients", clientsSpy);

        /* When */
        postman.notifyClients();

        /* Than */
        for (Client clientSpy : clientsSpy) {
            verify(clientSpy, times(1)).get("Macy's settles racial profiling cases.");
        }
    }
}