package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void createsAccountWithNonNegativeBalance() {
        BankAccount account = new BankAccount(500);

        assertEquals(500, account.getBalance());
    }

    @Test
    void rejectsNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-1));
    }

    @Test
    void depositsAndWithdrawsMoney() {
        BankAccount account = new BankAccount(500);

        account.deposit(200);
        account.withdraw(150);

        assertEquals(550, account.getBalance());
    }

    @Test
    void rejectsNonPositiveDeposit() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-5));
        assertEquals(100, account.getBalance());
    }

    @Test
    void rejectsNonPositiveWithdrawal() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5));
        assertEquals(100, account.getBalance());
    }

    @Test
    void rejectsWithdrawalGreaterThanBalance() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(101));

        assertEquals(100, account.getBalance());
    }

    @Test
    void rejectsBalanceOverflow() {
        BankAccount account = new BankAccount(Integer.MAX_VALUE);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(1));

        assertEquals(Integer.MAX_VALUE, account.getBalance());
    }
}
