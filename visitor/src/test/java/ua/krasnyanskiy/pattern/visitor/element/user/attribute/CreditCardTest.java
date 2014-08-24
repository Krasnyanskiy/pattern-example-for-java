package ua.krasnyanskiy.pattern.visitor.element.user.attribute;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertSame;

@PrepareForTest({BigDecimal.class, CreditCard.class})
public class CreditCardTest extends PowerMockTestCase {

    @Mock
    private CreditCard cardMock;

    @BeforeMethod
    public void before() {
        initMocks(this);
    }

    @Test
    public void should_construct_an_object_and_set_proper_field() throws Exception {

        /* Given */
        BigDecimal cardNumberMock = Mockito.mock(BigDecimal.class);
        whenNew(BigDecimal.class).withArguments(anyLong()).thenReturn(cardNumberMock);

        /* When */
        CreditCard creditCard = new CreditCard(1234567898765432L);

        /* Than */
        verifyNew(BigDecimal.class, times(1)).withArguments(1234567898765432L);
        assertSame(creditCard.getCardNumber(), cardNumberMock);
    }

    @Test
    public void should_set_field_while_constructing() {

        /* When */
        CreditCard creditCard = new CreditCard(1234567898765432L);

        /* Than */
        BigDecimal retrieved = creditCard.getCardNumber();
        assertNotNull(retrieved);
        assertEquals(retrieved, new BigDecimal(1234567898765432L));
    }

    @Test
    public void should_create_object_by_invoking_proper_constructor() throws Exception {

        /* Given */
        whenNew(CreditCard.class).withArguments(1234567898765432L).thenReturn(cardMock);

        /* When */
        CreditCard retrievedCard = new CreditCard(1234567898765432L);

        /* Than */
        assertNotNull(retrievedCard);
        assertSame(retrievedCard, cardMock);
        verifyNew(CreditCard.class, only()).withArguments(1234567898765432L);
    }

    @AfterMethod
    public void after() {
        reset(cardMock);
    }
}