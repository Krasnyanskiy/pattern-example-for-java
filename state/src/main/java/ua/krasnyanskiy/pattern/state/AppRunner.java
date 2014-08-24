package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {
    public static void main(String[] args) {

        Context context = new Context();

        State initialState = new FirstState();
        context.changeContextState(initialState); // update context

        context.execute(10);
        context.execute(20);
        context.execute(30);

        System.out.println("Completed: " + context.getCompletion() + "%");
    }
}
