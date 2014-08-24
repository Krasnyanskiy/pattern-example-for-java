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

    public void execute(Integer data) {
        currentState.execute(this, data);
    }
}
