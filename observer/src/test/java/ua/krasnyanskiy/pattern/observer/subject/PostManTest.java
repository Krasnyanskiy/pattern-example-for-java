package ua.krasnyanskiy.pattern.observer.subject;

import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.krasnyanskiy.pattern.observer.object.Businessman;
import ua.krasnyanskiy.pattern.observer.object.Client;
import ua.krasnyanskiy.pattern.observer.object.Housewife;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;

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
        List<Client> retrievedClients = (List<Client>) Whitebox.getInternalState(postman, "clients");
        Assert.assertTrue(retrievedClients.size() == 1);
    }

    @Test
    /**
     * for {@link PostMan#setNews(String)}
     */
    public void should_add_news_notify_all_subscribers() {

        /* Given */
        PostMan postmanSpy = Mockito.spy(new PostMan());
        Mockito.doNothing().when(postmanSpy).notifyClients();
        new Businessman("Bob", postmanSpy);

        /* When */
        postmanSpy.setNews("Macy's settles racial profiling cases.");

        /* Than */
        Mockito.verify(postmanSpy, times(1)).notifyClients();
        String retrievedNews = (String) Whitebox.getInternalState(postmanSpy, "news");
        Assert.assertNotNull(retrievedNews);
        Assert.assertEquals(retrievedNews, "Macy's settles racial profiling cases.");
    }

    @Test
    /**
     * for {@link PostMan#notifyClients()}
     */
    public void should_invoke_method_get_of_every_client() {

        /* Given */
        PostMan postman = new PostMan();

        final Client john = Mockito.spy(new Businessman("John", postman));
        final Client angelina = Mockito.spy(new Housewife("Angelina", postman));

        List<Client> clientsSpy = new ArrayList<Client>() {{
            add(john);
            add(angelina);
        }};

        Whitebox.setInternalState(postman, "news", "Macy's settles racial profiling cases.");
        Whitebox.setInternalState(postman, "clients", clientsSpy);

        /* When */
        postman.notifyClients();

        /* Than */
        for (Client clientSpy : clientsSpy) {
            Mockito.verify(clientSpy, times(1)).get("Macy's settles racial profiling cases.");
        }
    }
}