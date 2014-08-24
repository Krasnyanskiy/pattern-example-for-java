package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {
    public static void main(String[] args) {

        Context context = new Context();

        SuperState initialSuperState = new FirstState();
        context.changeContextState(initialSuperState); // update context

        context.goNextStep(15);
        context.goNextStep(20);
        context.goNextStep(30);

        System.out.println("Completed: " + context.getCompletion() + "%");
    }
}
