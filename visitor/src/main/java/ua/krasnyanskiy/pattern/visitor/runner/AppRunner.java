package ua.krasnyanskiy.pattern.visitor.runner;

import ua.krasnyanskiy.pattern.visitor.element.user.attribute.CreditCard;
import ua.krasnyanskiy.pattern.visitor.element.user.PrivilegedUser;
import ua.krasnyanskiy.pattern.visitor.element.user.StandardUser;
import ua.krasnyanskiy.pattern.visitor.element.user.User;
import ua.krasnyanskiy.pattern.visitor.element.user.UserGroupManager;
import ua.krasnyanskiy.pattern.visitor.operation.UserCardNumberPrintingVisitor;
import ua.krasnyanskiy.pattern.visitor.operation.UserPasswordDroppingVisitor;
import ua.krasnyanskiy.pattern.visitor.operation.Visitor;

import java.util.Arrays;

/**
 * @author Alexander Krasnyanskiy
 */
public class AppRunner {
    public static void main(String[] args) {

        /**
         * Setup node elements
         */
        User boss = new PrivilegedUser();
        boss.setPassword("qwerty");
        boss.setName("Larry Page");
        boss.setAge(41);
        ((PrivilegedUser) boss).setCard(new CreditCard(6434343223422342L));

        User employee = new StandardUser();
        employee.setPassword("12345");
        employee.setAge(21);
        employee.setName("Martin");

        /**
         * Prepare visitor operations
         */
        Visitor cardNumberPrintingVisitorVisitor = new UserCardNumberPrintingVisitor();
        Visitor passwordDroppingVisitor = new UserPasswordDroppingVisitor();

        /**
         * Build a object group manager
         */
        UserGroupManager manager = new UserGroupManager();
        manager.setGroup(Arrays.asList(boss, employee));

        manager.perform(cardNumberPrintingVisitorVisitor);
        manager.perform(passwordDroppingVisitor);

        /**
         * Checking result
         */
        System.out.println(boss.getPassword());
        System.out.println(employee.getPassword());
    }
}
