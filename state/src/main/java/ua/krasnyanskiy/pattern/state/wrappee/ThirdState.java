package ua.krasnyanskiy.pattern.state.wrappee;

import ua.krasnyanskiy.pattern.state.wrapper.Context;

import java.util.LinkedList;

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
        storedCash *= (newCash - 2) < 0 ? 0 : (newCash - 2);
        completion += 20;
        log();
    }

    @Override
    protected void printMessageAndTime() {
        System.out.println("Printed in the third state: <" + storedCash + ">" +
                " on " + ((LinkedList) content.get(stateName)).getLast());
    }
}
