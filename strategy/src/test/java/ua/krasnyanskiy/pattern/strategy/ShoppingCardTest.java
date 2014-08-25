package ua.krasnyanskiy.pattern.strategy;

import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.internal.util.reflection.Whitebox;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.krasnyanskiy.pattern.strategy.algorithm.CreditCardPaymentStrategy;
import ua.krasnyanskiy.pattern.strategy.entity.Product;
import ua.krasnyanskiy.pattern.strategy.entity.ShoppingCard;
import ua.krasnyanskiy.pattern.strategy.entity.Toy;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

public class ShoppingCardTest {

    @Mock
    private CreditCardPaymentStrategy strategyMock;

    @Spy
    private ShoppingCard cardSpy = new ShoppingCard();

    @BeforeMethod
    public void before() {
        initMocks(this);
    }

    @Test
    @SuppressWarnings("unchecked")
    public void should_initialize_list_of_products_when_creating_an_object() {

        /* When */
        ShoppingCard card = new ShoppingCard();
        List<Product> retrievedProductsAfterInitialization =
                (List<Product>) Whitebox.getInternalState(card, "products");

        /* Than */
        assertNotNull(retrievedProductsAfterInitialization);
        assertTrue(retrievedProductsAfterInitialization.isEmpty());
    }

    @Test
    public void should_return_proper_property_with_getter() {

        /* When */
        ShoppingCard card = new ShoppingCard();

        /* Than */
        assertNotNull(card.getProducts());
        assertTrue(card.getProducts().isEmpty());
    }

    @Test
    public void should_add_products_property_with_proper_items() {

        /* Given */
        ShoppingCard card = new ShoppingCard();

        /* When */
        card.setProducts(new ArrayList<Product>() {{
            add(new Toy(23, "LEGO Bricks & More Builders of Tomorrow Set"));
            add(new Toy(102, "DreamWorks Dragons Defenders of Berk - Mini Dragons Figures Toothless"));
        }});

        /* Than */
        assertTrue(card.getProducts().size() == 2);
        assertEquals(card.getProducts().get(0).getName(), "LEGO Bricks & More Builders of Tomorrow Set");
        assertSame(card.getProducts().get(0).getPrice(), 23);
        assertEquals(card.getProducts().get(1).getName(),
                "DreamWorks Dragons Defenders of Berk - Mini Dragons Figures Toothless");
    }

    @Test
    public void should_add_one_product_into_products_property() {

        /* Given */
        ShoppingCard card = new ShoppingCard();

        /* When */
        card.addProduct(new Toy(23, "LEGO Bricks & More Builders of Tomorrow Set"));

        /* Than */
        assertTrue(card.getProducts().size() == 1);
    }

    @Test
    public void should_add_amount() {

        /* Given */
        ShoppingCard card = new ShoppingCard();
        card.addProduct(new Toy(23, "LEGO Bricks & More Builders of Tomorrow Set"));
        card.addProduct(new Toy(23, "LEGO Bricks & More Builders of Tomorrow Set"));

        /* When */
        int retrieved = card.calculateTotal();

        /* Than */
        assertTrue(retrieved == 46);
    }

    @Test
    public void should_invoke_calculateTotal_and_pay_method_on_strategy_instance() throws InterruptedException {

        /* Given */
        doNothing().when(strategyMock).pay(anyInt());
        doReturn(100).when(cardSpy).calculateTotal();

        /* When */
        cardSpy.pay(strategyMock);

        /* Than */
        verify(strategyMock, times(1)).pay(100);
        verify(cardSpy, times(1)).calculateTotal();
    }

    @Test
    public void should_delete_product() {

        /* Given */
        ShoppingCard card = new ShoppingCard();
        Toy buildersSet = new Toy(23, "LEGO Bricks & More Builders of Tomorrow Set");
        card.addProduct(buildersSet);
        card.addProduct(buildersSet);

        /* Property size confirmation */
        assertTrue(card.getProducts().size() == 2);

        /* When */
        card.deleteProduct(buildersSet);

        /* Than */
        assertTrue(card.getProducts().size() == 1);
    }

    @AfterMethod
    public void after() {
        reset(strategyMock, cardSpy);
    }
}