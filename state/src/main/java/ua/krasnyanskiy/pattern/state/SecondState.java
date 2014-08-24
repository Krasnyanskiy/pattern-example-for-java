package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class SecondState extends SuperState {

    @Override
    public void execute(Context ctx, Integer cash) {
        calculate(cash);
        ctx.changeContextState(SuperState.cash > 56 ? this : new ThirdState()); // todo: see how modification of context depends on {cash}
    }

    private void calculate(Integer cash) {
        SuperState.cash += (cash - 5);
        completion += 5;
        System.out.println("Printed in the second state: " + SuperState.cash);
    }
}
