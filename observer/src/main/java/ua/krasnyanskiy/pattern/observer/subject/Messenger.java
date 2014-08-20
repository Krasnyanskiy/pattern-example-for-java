package ua.krasnyanskiy.pattern.observer.subject;

import ua.krasnyanskiy.pattern.observer.object.Client;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class Messenger {
    public abstract void registerClient(Client client);
    public abstract void removeClient(Client client);
    public abstract void notifyClients();

    public abstract void setNews(String news);
}
