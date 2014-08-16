package ua.krasnyanskiy.pattern.memento;

import ua.krasnyanskiy.pattern.memento.support.Criteria;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class Caretaker {

    List<Originator.Memento> snapshots;

    public Caretaker() {
        this.snapshots = new ArrayList<Originator.Memento>();
    }

    public Caretaker(List<Originator.Memento> snapshots) {
        this.snapshots = snapshots;
    }

    public void addSnapshot(Originator.Memento memento) {
        snapshots.add(memento);
    }

    public List<Originator.Memento> getSnapshots() {
        return snapshots;
    }

    /**
     * Even though guys from GOF insist that 'The Caretaker provides storage only; it should neither
     * examine nor modify the contents of the Memento object' I still added a search logic into the
     * Caretaker class.
     */
    public Originator.Memento find(Criteria criteria, Object key) {
        switch (criteria) {
            case ByCode:
                for (Originator.Memento state : snapshots) {
                    if (state.getCode().equals(key)) {
                        return state;
                    }
                }
                break;
            case ByState:
                for (Originator.Memento state : snapshots) {
                    if (state.getState().equals(key)) {
                        return state;
                    }
                }
                break;
            case ByParameterKey:
                for (Originator.Memento state : snapshots) {
                    if (state.getParameters().containsKey(key)) {
                        return state;
                    }
                }
        }
        return null;
    }
}
