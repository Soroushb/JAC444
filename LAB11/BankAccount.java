
public class BankAccount {
private double balance = 0;

synchronized void deposit(double amount) {
	
    System.out.println("\nDeposit:");

    while(amount <= 0.00){
        System.out.println("Please enter the valid amount");
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    balance += amount;
    
    System.out.println("Your new balance is " + balance);
    notify();
}

synchronized void withdraw(double amount){
    System.out.println("\nWithdraw:");

    while (balance == 0.0 || amount <= 0.00) {
        System.out.println("Insufficient funds or invalid amount");

        try {
            wait();
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
    }

    if(balance > 0.0){
        balance -= amount;
        System.out.println("New balance is " + balance);
        notify();
    }
}
}
