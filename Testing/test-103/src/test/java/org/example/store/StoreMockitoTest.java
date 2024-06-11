package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;



//import static org.mockito.Mockito.*;

public class StoreMockitoTest {

    Store store;

    Product product = new Product();
    Customer customer = new Customer();


    @Test
    void givenValidProductQuantityAndSuccessfulWithdrawWhenBuyThenDecreaseQuantity() {
        // Arrange
        product.setQuantity(8);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        Mockito.when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        store = new StoreImpl(accountManager);

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(7, product.getQuantity());
    }

    @Test
    void givenInvalidProductQuantityAndSuccessfulWithdrawWhenBuyThenDecreaseQuantity(){
        // Arrange
        product.setQuantity(0);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        Mockito.when(accountManager.withdraw(any(),anyInt())).thenReturn("success");
        store = new StoreImpl(accountManager);


        // Act
        Assertions.assertThrows(RuntimeException.class, () -> {
            store.buy(product, customer);
        });
    }

    @Test
    void givenValidProductQuantityAndFailedWithdrawWhenBuyThenQuantitydoesntDecreased() {
        // Arrange
        product.setQuantity(8);
        AccountManager accountManager = Mockito.mock(AccountManager.class);
        Mockito.when(accountManager.withdraw(any(), anyInt())).thenReturn("maximum credit exceeded");
        store = new StoreImpl(accountManager);

        // Act
        //store.buy(product, customer);

        // Assert
        Assertions.assertThrows(RuntimeException.class, () -> {
            store.buy(product, customer);
        });
    }

}
