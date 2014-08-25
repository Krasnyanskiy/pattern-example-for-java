package ua.krasnyanskiy.pattern.state.wrappee;

import ua.krasnyanskiy.pattern.state.wrapper.Context;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class State {

    public static Map<String, List<Date>> content = new HashMap<String, List<Date>>(); // where key is the name of State, and val is the State parameters
    public static int storedCash;
    public static int completion; // the percentage of completion

    protected String stateName;

    public abstract void execute (Context ctx, Integer data);

    /**
     * Simple Template Method Pattern implementation
     */
    protected void log() {
        List<Date> parameters = content.get(stateName);
        if (parameters != null) {
            parameters.add(new Date());
        } else {
            content.put(stateName, new LinkedList<Date>() {{
                add(new Date());
            }});
        }
        printMessageAndTime();
    }

    protected abstract void printMessageAndTime();
}
