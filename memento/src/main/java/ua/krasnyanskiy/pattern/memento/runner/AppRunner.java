package ua.krasnyanskiy.pattern.memento.runner;

import ua.krasnyanskiy.pattern.memento.Caretaker;
import ua.krasnyanskiy.pattern.memento.Originator;

import java.util.HashMap;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {

    /**
     * Please see another cool implementation here
     * <a href="http://stackoverflow.com/questions/14082892/different-ways-to-implement-the-memento-pattern-in-java">link<a/>
     */
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
         * Changing and saving with Memento the states of Originator
         */
        Caretaker caretaker = new Caretaker();
        caretaker.addSnapshot(originator.save());
        System.out.println(originator);

        originator.setCode(500);
        caretaker.addSnapshot(originator.save());
        System.out.println(originator);

        originator.setCode(1500);
        caretaker.addSnapshot(originator.save());
        System.out.println(originator);

        /**
         * We even could make some search with Caretaker
         */
        //Originator.Memento m = caretaker.find(Criteria.ByCode, 500);

        /**
         * And finally restoring an object
         */
        originator.restore(caretaker.getSnapshots().get(1));
        System.out.println(originator);
    }
}