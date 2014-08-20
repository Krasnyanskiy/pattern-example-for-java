package ua.krasnyanskiy.pattern.observer.subject;

import ua.krasnyanskiy.pattern.observer.object.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class PostMan extends Messenger {

    private List<Client> clients;
    private String news;

    public PostMan() {
        clients = new ArrayList<Client>();
    }

    @Override
    public void registerClient(Client client) {
        clients.add(client);
    }

    @Override
    public void removeClient(Client client) {
        clients.remove(client);
    }

    @Override
    public void setNews(String news) {
        this.news = news;
        notifyClients();
    }

    @Override
    public void notifyClients() {
        for (Client client : clients) {
            client.get(news);
        }
    }
}
