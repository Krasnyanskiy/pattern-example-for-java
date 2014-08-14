package ua.krasnyanskiy.pattern.memento;

import com.rits.cloning.Cloner;

import java.util.Map;

/**
 * @author Alexander Krasnyanskiy
 */
public class Memento {
    private String state;
    private Integer code;
    private Map<String, String> parameters;

    public Memento(Originator originator) {

        // Cloner setup
        Cloner cloner = new Cloner();

        // Makes deep clones of objects and sets the fields
        this.state = cloner.deepClone(originator.getState());
        this.code = cloner.deepClone(originator.getCode());
        this.parameters = cloner.deepClone(originator.getParameters());
    }

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
}