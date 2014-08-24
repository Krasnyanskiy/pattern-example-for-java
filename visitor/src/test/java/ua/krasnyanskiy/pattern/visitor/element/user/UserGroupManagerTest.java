package ua.krasnyanskiy.pattern.visitor.element.user;

import org.mockito.Mock;
import org.mockito.Spy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.krasnyanskiy.pattern.visitor.operation.Visitor;

import java.util.Arrays;

import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserGroupManagerTest {

    @Spy
    private User privilegedUserSpy = new PrivilegedUser();

    @Spy
    private User standardUserSpy = new StandardUser();

    @Mock
    private Visitor visitorMock;

    @BeforeMethod
    public void before() {
        initMocks(this);
    }

    @Test
    public void should_invoke_perform_method_of_all_members_of_given_collection_with_proper_visitor() {

        /* Given */
        final UserGroupManager mediator = new UserGroupManager();
        mediator.setGroup(Arrays.asList(privilegedUserSpy, standardUserSpy));

        /* When */
        mediator.perform(visitorMock);

        /* Than */
        for (User userSpy : mediator.getGroup()) {
            verify(userSpy, times(1)).perform(visitorMock);
        }
    }

    @AfterMethod
    public void after() {
        reset(visitorMock, standardUserSpy, privilegedUserSpy);
    }
}