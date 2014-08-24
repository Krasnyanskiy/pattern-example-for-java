package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public interface State {
    public void execute (Context ctx, Integer data);
}
