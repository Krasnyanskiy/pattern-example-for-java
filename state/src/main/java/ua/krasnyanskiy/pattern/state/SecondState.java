package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class SecondState extends State {

    @Override
    public void execute(Context ctx, Integer cash) {
        State me = this;
        calculate(cash);

        // todo: see how modification of context depends on {data}
        ctx.changeContextState(State.cash > 56 ? me : new ThirdState());
    }

    private void calculate(Integer cash) {
        State.cash += (cash - 5);
        completion += 5;
        System.out.println("Printed in the second state: " + State.cash);
    }
}
