package ua.krasnyanskiy.pattern.templatemethod;

/**
 * @author Alexander Krasnyanskiy
 */
public class Impl extends TemplateClass{

    @Override
    void sort(Object[] array) {
        super.sort(array);
    }

    @Override
    void prepare() {
        System.out.println("info");
    }
}
