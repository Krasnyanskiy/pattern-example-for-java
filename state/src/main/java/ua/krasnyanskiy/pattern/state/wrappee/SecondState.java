package ua.krasnyanskiy.pattern.state.wrappee;

import ua.krasnyanskiy.pattern.state.wrapper.Context;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class SecondState extends State {

    public SecondState() {
        stateName = "second";
    }

    @Override
    public void execute(Context ctx, Integer newCash) {
        calculate(newCash);
        ctx.changeContextState(storedCash > 56 ? this : new ThirdState()); // todo: see how modification of context depends on {storedCash}
    }

    private void calculate(Integer newCash) {
        List<Date> parameters;

        if ((parameters = content.get(stateName)) != null) {
            parameters.add(new Date());
        } else {
            content.put(stateName, new LinkedList<Date>() {{
                add(new Date());
            }});
        }

        storedCash += (newCash - 5);
        completion += 5;
        System.out.println("Printed in the second state: " + storedCash +
                " on " + ((LinkedList) content.get(stateName)).getLast());
    }
}
