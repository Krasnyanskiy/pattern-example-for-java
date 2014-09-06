package ua.krasnyanskiy.pattern.observer.subject;

import ua.krasnyanskiy.pattern.observer.object.Client;

/**
 * @author Alexander Krasnyanskiy
 */
public interface Messenger {

    void registerClient(Client client);
    void removeClient(Client client);
    void notifyClients();
    void setNews(String news);
}
