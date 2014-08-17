package ua.krasnyanskiy.pattern.visitor.element.user;

import ua.krasnyanskiy.pattern.visitor.operation.Visitor;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class User {

    private Integer age;
    private String name;
    private String password;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void perform(Visitor operation);
}
