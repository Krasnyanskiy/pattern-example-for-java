package ua.krasnyanskiy.pattern.memento;

import ua.krasnyanskiy.pattern.memento.support.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class Caretaker {

    List<Memento> states;

    public Caretaker() {
        if (states == null) {
            states = new ArrayList<Memento>();
        }
    }

    public Caretaker(List<Memento> states) {
        this.states = states;
    }

    public void addSnapshot(Memento memento) {
        states.add(memento);
    }

    public List<Memento> getSnapshots() {
        return states;
    }

    public Memento find(Criteria criteria, Object key) {
        switch (criteria) {
            case ByCode:
                for (Memento state : states) {
                    if (state.getCode().equals(key)) {
                        return state;
                    }
                }
                break;
            case ByState:
                for (Memento state : states) {
                    if (state.getState().equals(key)) {
                        return state;
                    }
                }
                break;
            case ByParameterKey:
                for (Memento state : states) {
                    if (state.getParameters().containsKey(key)) {
                        return state;
                    }
                }
        }
        return null;
    }
}
