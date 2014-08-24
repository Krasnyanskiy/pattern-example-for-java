package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class ThirdState extends SuperState {

    @Override
    public void execute(Context ctx, Integer cash) {
        recalculation(cash);
        ctx.changeContextState(SuperState.cash < 10 ? this : new FirstState());
    }

    private void recalculation(Integer cash) {
        SuperState.cash *= (cash - 2) < 0 ? 0 : (cash - 2);
        completion += 20;
        System.out.println("Printed in the third state: <" + SuperState.cash + ">");
    }
}
