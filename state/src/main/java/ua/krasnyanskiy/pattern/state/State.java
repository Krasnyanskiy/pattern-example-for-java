package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class State {

    protected int completion; // the percentage of completion

    public abstract void execute (Context ctx, Integer data);
}
