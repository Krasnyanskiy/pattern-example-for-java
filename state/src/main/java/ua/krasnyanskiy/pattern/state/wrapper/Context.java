package ua.krasnyanskiy.pattern.state.wrapper;

import ua.krasnyanskiy.pattern.state.wrappee.State;

import static ua.krasnyanskiy.pattern.state.wrappee.State.completion;

/**
 * It's a Wrapper class.
 *
 * @author Alexander Krasnyanskiy
 */
public class Context {
    private State currentState;

    public Context() {
    }

    public void changeContextState(State newState) {
        currentState = newState;
    }

    public void goNextStep(Integer newCash) {
        currentState.execute(this, newCash);
    }

    public int getCompletion() {
        return completion;
    }
}
