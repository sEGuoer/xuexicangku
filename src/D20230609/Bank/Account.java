package D20230609.Bank;

public class Account {
    //state
    private int id;
    private double balance;
    private double annualInterestRate;


    public Account() {
    }

    //behavior
    public void setID(int id) {
        this.id = id;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getID() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void withdrow(double a) {
        if (this.balance - a < 0) {
            System.out.println("余额不足，取款失败");
        } else {
            this.balance = balance - a;
            System.out.println("成功取出:" + a);
        }
    }

    public double deposit(double a) {
        this.balance = balance + a;
        System.out.println("成功存入:" + a);
        return balance;
    }
}
