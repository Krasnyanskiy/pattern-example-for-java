package ua.krasnyanskiy.pattern.state.wrappee;

import ua.krasnyanskiy.pattern.state.wrapper.Context;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class FirstState extends State {

    public FirstState() {
        stateName = "1st";
    }

    @Override
    public void execute(Context ctx, Integer newCash) {
        process(newCash);
        ctx.changeContextState(storedCash > 80 ? this : new SecondState()); // modification of context
    }

    private void process(Integer newCash) {
        List<Date> parameters;

        if ((parameters = content.get(stateName)) != null) {
            parameters.add(new Date());
        } else {
            content.put(stateName, new LinkedList<Date>() {{
                add(new Date());
            }});
        }

        storedCash += newCash;
        completion += 30;
        System.out.println("Printed in the first state object: {" + storedCash + "}" +
                " on " + ((LinkedList) content.get(stateName)).getLast());
    }
}
