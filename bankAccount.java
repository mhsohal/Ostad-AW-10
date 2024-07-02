class BankAccount {
    protected double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class SavingsAccount extends BankAccount {
    private static final double WITHDRAWAL_LIMIT = 500.00;

    public SavingsAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > WITHDRAWAL_LIMIT) {
            System.out.println("Withdrawal amount exceeds the limit of " + WITHDRAWAL_LIMIT);
        } else {
            super.withdraw(amount);
        }
    }
}

class CheckingAccount extends BankAccount {
    private static final double WITHDRAWAL_FEE = 2.00;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount + WITHDRAWAL_FEE <= balance) {
            balance -= (amount + WITHDRAWAL_FEE);
            System.out.println("Withdrawn: " + amount + " with fee: " + WITHDRAWAL_FEE + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance to cover the withdrawal and fee.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount(1000);
        BankAccount checking = new CheckingAccount(1000);

        savings.deposit(200);
        savings.withdraw(600);
        savings.withdraw(400);

        checking.deposit(300);
        checking.withdraw(1200);
        checking.withdraw(300);
    }
}
