package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class SecondState extends State {

    @Override
    public void execute(Context ctx, Integer data) {
        State me = this;
        runJob(data += 15);

        // todo: see how modification of context depends on {data}
        ctx.changeContextState(data > 100 ? me : new ThirdState());
    }

    private void runJob(Integer data) {
        completion += 5;
        System.out.println("Printed in the second state: " + data);
    }
}
