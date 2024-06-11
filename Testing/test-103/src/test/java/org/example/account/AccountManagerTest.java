package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

    Customer customer = new Customer();
    AccountManager accountManager = new AccountManagerImpl();

    @Test
    void givenAmountBelowMaxCreditForNormalCustomerWhenWithdrawThenSubtractFromBalance() {
        // Arrange
        customer.setBalance(100);

        // Act
        String result = accountManager.withdraw(customer, 80);
        int expectedBalance = customer.getBalance();

        // Assert

        Assertions.assertEquals(20, expectedBalance);
        Assertions.assertEquals("success", result);
    }

    @Test
    void givenAmountAboveMaxCreditForNormalCustomerWhenWithdrawThenReturnInsufficientBalance() {
        // Arrange
        customer.setBalance(100);

        // Act
        String result = accountManager.withdraw(customer, 120);

        // Assert
        Assertions.assertEquals("insufficient account balance", result);
    }

    @Test
    void givenAmountAboveMaxCreditForVipCustomertWhenWithdrawThenReturnSuccess() {
        // Arrange
        customer.setBalance(100);
        customer.setVip(true);
        customer.setCreditAllowed(true);

        // Act
        String result = accountManager.withdraw(customer, 2000);
        int expectedBalance = customer.getBalance();

        // Assert
        Assertions.assertEquals(-1900, expectedBalance);
        Assertions.assertEquals("success", result);

    }


    @Test
    void givenAmountAboveMaxCreditForNormalCustomerAndDontExceedMaxCreditWhenWithdrawThenReturnSuccess() {
        // Arrange
        customer.setBalance(100);
        customer.setCreditAllowed(true);


        // Act
        String result = accountManager.withdraw(customer, 1000);
        int expectedBalance = customer.getBalance();


        // Assert
        Assertions.assertEquals(-900, expectedBalance);
        Assertions.assertEquals("success", result);
    }

    @Test
    void givenAmountAboveMaxCreditForNormalCustomerAndExceedMaxCreditWhenWithdrawThenReturnMaximumCreditExceeded() {
        // Arrange
        customer.setBalance(100);
        customer.setCreditAllowed(true);


        // Act
        String result = accountManager.withdraw(customer, 2000);
        int expectedBalance = customer.getBalance();


        // Assert
        Assertions.assertEquals(100, expectedBalance);
        Assertions.assertEquals("maximum credit exceeded", result);
    }



}
