package ua.krasnyanskiy.pattern.observer.runner;

import ua.krasnyanskiy.pattern.observer.object.Businessman;
import ua.krasnyanskiy.pattern.observer.object.Housewife;
import ua.krasnyanskiy.pattern.observer.subject.Messenger;
import ua.krasnyanskiy.pattern.observer.subject.PostMan;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {
    public static void main(String[] args) {

        Messenger postman = new PostMan();

        new Businessman("Ben", postman);
        new Housewife("Liza", postman);

        postman.setNews("@ Peace is now in whole world!");
        postman.setNews("@ War.");
        postman.setNews("@ And peace again.");
    }
}
