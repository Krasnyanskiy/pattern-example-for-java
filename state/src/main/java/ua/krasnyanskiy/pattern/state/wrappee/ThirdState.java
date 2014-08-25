package ua.krasnyanskiy.pattern.state.wrappee;

import ua.krasnyanskiy.pattern.state.wrapper.Context;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class ThirdState extends State {

    public ThirdState() {
        stateName = "3rd_state";
    }

    @Override
    public void execute(Context ctx, Integer newCash) {
        recalculation(newCash);
        ctx.changeContextState(storedCash < 10 ? this : new FirstState());
    }

    private void recalculation(Integer newCash) {
        List<Date> parameters;

        if ((parameters = content.get(stateName)) != null) {
            parameters.add(new Date());
        } else {
            content.put(stateName, new LinkedList<Date>(){{add(new Date());}});
        }

        storedCash *= (newCash - 2) < 0 ? 0 : (newCash - 2);
        completion += 20;
        System.out.println("Printed in the third state: <" + storedCash + ">" +
                " on " + ((LinkedList)content.get("3rd_state")).getLast());
    }
}
