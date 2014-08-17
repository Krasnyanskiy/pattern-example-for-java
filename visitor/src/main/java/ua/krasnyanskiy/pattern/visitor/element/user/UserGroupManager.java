package ua.krasnyanskiy.pattern.visitor.element.user;

import ua.krasnyanskiy.pattern.visitor.element.user.User;
import ua.krasnyanskiy.pattern.visitor.operation.Visitor;

import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class UserGroupManager extends User {

    private List<User> group; // object structure with POJOs

    public List<User> getGroup() {
        return group;
    }

    public void setGroup(List<User> group) {
        this.group = group;
    }

    @Override
    public void perform(Visitor operation) {
        for (User user : group) {
            user.perform(operation);
        }
    }
}
