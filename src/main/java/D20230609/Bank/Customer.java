package D20230609.Bank;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAccount(int id, int balance, double AnnualInterestRate) {
        Account a = new Account();
        a.setID(id);
        a.setBalance(balance);
        a.setAnnualInterestRate(AnnualInterestRate);
        this.account = a;
    }

    public Account getAccount() {
        return account;
    }

    public void showAccount() {
        System.out.println("Customer [" + firstName + lastName + "] 有一个账户: " + account.getID() + ", annualInterestRate=" + account.getAnnualInterestRate() + "%, balance=" + account.getBalance());
    }
}
