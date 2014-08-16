package ua.krasnyanskiy.pattern.memento;

import com.rits.cloning.Cloner;

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
        this.state = memento.getState();
        this.code = memento.getCode();
        this.parameters = memento.getParameters();
    }

    /**
     * We use Memento class for making a snapshot of Originator state.
     */
    public class Memento {
        private String state;
        private Integer code;
        private Map<String, String> parameters;

        public Memento(Originator o) {
            Cloner cloner = new Cloner();
            this.parameters = cloner.deepClone(o.parameters);

            // we don't need to use deep clone because Integer and String are immutable classes
            this.state = o.state;
            this.code = o.code;
        }

        /**
         * Here we have only getters. This is a narrow interface which provides
         * access only for clone of state.
         */
        public String getState() {
            return state;
        }

        public Integer getCode() {
            return code;
        }

        public Map<String, String> getParameters() {
            return parameters;
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
