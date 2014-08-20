package ua.krasnyanskiy.pattern.observer.object;

import ua.krasnyanskiy.pattern.observer.subject.Messenger;

/**
 * @author Alexander Krasnyanskiy
 */
public class Housewife implements Client {

    private String HousewifeName;
    private String latestNews;

    public Housewife(String HousewifeName, Messenger messenger) {
        this.HousewifeName = HousewifeName;
        messenger.registerClient(this);
    }

    @Override
    public void get(String news) {
        latestNews = news;
        System.out.println("Yahoo! My HousewifeName is " + HousewifeName + ", and I got the the latest news: " + latestNews);
    }
}
