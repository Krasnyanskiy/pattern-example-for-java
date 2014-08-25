package ua.krasnyanskiy.pattern.state.wrappee;

import ua.krasnyanskiy.pattern.state.wrapper.Context;

import java.util.LinkedList;

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
        storedCash += (newCash - 5);
        completion += 5;
        log();
    }

    @Override
    protected void printMessageAndTime() {
        System.out.println("Printed in the second state: " + storedCash +
                " on " + ((LinkedList) content.get(stateName)).getLast());
    }
}
