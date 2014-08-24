package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class FirstState extends State {

    @Override
    public void execute(Context ctx, Integer cash) {
        State me = this;
        process(cash);
        ctx.changeContextState(State.cash > 80 ? me : new SecondState()); // modification of context
    }

    private void process(Integer cash) {
        State.cash += cash;
        completion += 30;
        System.out.println("Printed in the first state object: {" + State.cash + "}");
    }
}
