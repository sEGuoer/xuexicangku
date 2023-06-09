package D20230609;

import D20230609.Bank.Account;

public class Customer {
    public static void main(String[] args) {
        D20230609.Bank.Customer b = new D20230609.Bank.Customer("小", "富");
        Account a = b.setAccount(1000, 2000, 1.23);
        a.deposit(100);
        a.withdrow(960);
        a.withdrow(2000);
        //System.out.println(a.getBalance());
        b.getAccount();
    }
}
