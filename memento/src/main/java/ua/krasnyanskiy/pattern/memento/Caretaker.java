package ua.krasnyanskiy.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class Caretaker {

    private List<Originator.Memento> snapshots;

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
     *
     *
     * UPD (important):
     *
     * Guys form GOF were wright! Examine methods break all encapsulation! So we don't need to
     * use them at all!
     */
    /*            
    public Originator.Memento find(Criteria criteria, Object key) {
        switch (criteria) {
            case ByCode:
                for (Originator.Memento snapshot : snapshots) {
                    if (snapshot.code.equals(key)) {
                        return snapshot;
                    }
                }
                break;
            case ByState:
                for (Originator.Memento snapshot : snapshots) {
                    if (snapshot.code.equals(key)) {
                        return snapshot;
                    }
                }
                break;
            case ByParameterKey:
                for (Originator.Memento snapshot : snapshots) {
                    if (snapshot.parameters.containsKey(key)) {
                        return snapshot;
                    }
                }
        }
        return null;
    }
    */
}
