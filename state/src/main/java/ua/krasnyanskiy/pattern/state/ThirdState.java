package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class ThirdState extends State {

    @Override
    public void execute(Context ctx, Integer data) {
        State me = this;
        runJob(data *= 2);

        // todo: see how modification of context depends on {data}
        ctx.changeContextState(data > 7 ? me : new FirstState());
    }

    private void runJob(Integer data) {
        completion += 25;
        System.out.println("Printed in the second state: " + data);
    }
}