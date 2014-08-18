package ua.krasnyanskiy.pattern.templatemethod;

/**
 * @author Alexander Krasnyanskiy
 */
public abstract class TemplateClass {

    void sort(Object[] array) {
        prepare();
    }

    abstract void prepare();
}
