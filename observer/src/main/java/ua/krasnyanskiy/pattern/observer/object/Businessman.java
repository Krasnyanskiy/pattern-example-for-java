package ua.krasnyanskiy.pattern.observer.object;

import ua.krasnyanskiy.pattern.observer.subject.Messenger;

/**
 * @author Alexander Krasnyanskiy
 */
public class Businessman implements Client { // observer (наблюдатель)

    private String businessmanName;
    private String latestNews;

    public Businessman(String businessmanName, Messenger messenger) {
        this.businessmanName = businessmanName;
        messenger.registerClient(this);
    }

    @Override
    public void get(String news) {
        latestNews = news;
        System.out.println("Huh! I'm " + businessmanName + ". Here is my latest news: " + latestNews);
    }
}
