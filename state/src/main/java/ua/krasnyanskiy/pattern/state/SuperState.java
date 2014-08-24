package ua.krasnyanskiy.pattern.state;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class SuperState {

    /*protected */static int cash;
    /*protected */static int completion; // the percentage of completion

    public abstract void execute (Context ctx, Integer data);
}
