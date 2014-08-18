package ua.krasnyanskiy.pattern.memento;

import java.util.Map;

/**
 * @author Alexander Krasnyanskiy
 */
public class Originator {

    private String state;
    private Integer code;
    private Map<String, String> parameters;

    /**
     * We have only setter here for security purposes (encapsulation). I mean we don't need
     * to provide any access to the secret state for anybody.
     */
    public void setState(String state) {
        this.state = state;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Memento save() {
        return new Memento(this);
    }

    public void restore(Memento memento) {
        this.state = memento.state;
        this.code = memento.code;
        this.parameters = memento.parameters;
    }

    /**
     * We use Memento class for making a snapshot of Originator state.
     */
    public class Memento {

        // field must be final
        private final String state;
        private final Integer code;
        private final Map<String, String> parameters;

        public Memento(Originator o) {
            this.parameters = o.parameters;
            this.state = o.state;
            this.code = o.code;
        }
    }

    // for demo only
    @Override
    public String toString() {
        return "Originator{" +
                "state='" + state + '\'' +
                ", code=" + code +
                ", parameters=" + parameters +
                '}';
    }
}
