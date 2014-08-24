package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class ThirdState extends State {

    @Override
    public void execute(Context ctx, Integer cash) {
        State me = this;
        runJob(cash);

        // todo: see how modification of context depends on {cash}
        ctx.changeContextState(State.cash < 10 ? me : new FirstState());
    }

    private void runJob(Integer cash) {
        State.cash *= (cash - 2) < 0 ? 0 : (cash - 2);
        completion += 20;
        System.out.println("Printed in the third state: <" + State.cash + ">");
    }
}
