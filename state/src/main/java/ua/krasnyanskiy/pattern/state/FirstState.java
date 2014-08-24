package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class FirstState extends SuperState {

    @Override
    public void execute(Context ctx, Integer cash) {
        process(cash);
        ctx.changeContextState(SuperState.cash > 80 ? this : new SecondState()); // modification of context
    }

    private void process(Integer cash) {
        SuperState.cash += cash;
        completion += 30;
        System.out.println("Printed in the first state object: {" + SuperState.cash + "}");
    }
}
