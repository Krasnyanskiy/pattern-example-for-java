package ua.krasnyanskiy.pattern.memento;

import java.util.Map;

/**
 * @author Alexander Krasnyanskiy
 */
public class Originator {

    private String state;
    private Integer code;
    private Map<String, String> parameters;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, String> getParameters() {
        return parameters;
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

    @Override
    public String toString() {
        return "Originator{" +
                "state='" + state + '\'' +
                ", code=" + code +
                ", parameters=" + parameters +
                '}';
    }
}
