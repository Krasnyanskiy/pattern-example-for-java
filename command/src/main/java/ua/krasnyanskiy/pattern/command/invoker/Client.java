package ua.krasnyanskiy.pattern.command.invoker;

import ua.krasnyanskiy.pattern.command.job.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
public class Client implements Invoker {
    List<Command> commands = new ArrayList<Command>();

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}
