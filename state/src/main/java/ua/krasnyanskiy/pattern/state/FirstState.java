package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class FirstState implements State {

    @Override
    public void execute(Context ctx, Integer data) {
        State me = this;
        doJob(data -= 100);
        ctx.changeContextState(data > 100 ? me : new SecondState()); // modification of context
    }

    private void doJob(Integer data) {
        System.out.println("Printed in the first state object: {" + data + "}");
    }
}
