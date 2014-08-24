package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public class Context {
    private State currentState;

    public Context() {

    }

    public void changeContextState(State newState) {
        currentState = newState;
    }

    public void goNextStep(Integer cash) {
        currentState.execute(this, cash);
    }


    public int getCompletion() {
        return State.completion;
    }
}
