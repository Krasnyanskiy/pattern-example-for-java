package ua.krasnyanskiy.pattern.state;

/**
 * It's a Wrapper class.
 *
 * @author Alexander Krasnyanskiy
 */
public class Context {
    private SuperState currentSuperState;

    public Context() {
    }

    public void changeContextState(SuperState newSuperState) {
        currentSuperState = newSuperState;
    }

    public void goNextStep(Integer cash) {
        currentSuperState.execute(this, cash);
    }

    public int getCompletion() {
        return SuperState.completion;
    }
}
