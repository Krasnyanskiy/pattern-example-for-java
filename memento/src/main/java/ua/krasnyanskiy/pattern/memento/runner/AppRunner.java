package ua.krasnyanskiy.pattern.memento.runner;

import ua.krasnyanskiy.pattern.memento.Caretaker;
import ua.krasnyanskiy.pattern.memento.Criteria;
import ua.krasnyanskiy.pattern.memento.Memento;
import ua.krasnyanskiy.pattern.memento.Originator;

import java.util.HashMap;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {
    public static void main(String[] args) {

        Originator originator = new Originator();

        /**
         * Setup an originator
         */
        originator.setCode(100);
        originator.setState("active");
        originator.setParameters(new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
        }});


        /**
         * Changing and saving with Memento the states of originator
         */
        Caretaker caretaker = new Caretaker();
        caretaker.addSnapshot(originator.save());

        originator.setCode(500);
        caretaker.addSnapshot(originator.save());

        originator.setCode(1500);
        caretaker.addSnapshot(originator.save());

        /**
         * We even could make some search with Caretaker
         */
        Memento m = caretaker.find(Criteria.ByCode, 500);

        /**
         * And finally restoring on object
         */
        originator.restore(m);
    }
}