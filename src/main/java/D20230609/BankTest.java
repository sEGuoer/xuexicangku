package D20230609;

import D20230609.Bank.Account;

public class BankTest {
    public static void main(String[] args) {
        D20230609.Bank.Customer Customer = new D20230609.Bank.Customer("小", "富");
        Customer.setAccount(1000, 2000, 1.23);
        Account a = Customer.getAccount();
        a.deposit(100);
        a.withdrow(960);
        a.withdrow(2000);
        //System.out.println(a.getBalance());
        Customer.showAccount();
    }
}
