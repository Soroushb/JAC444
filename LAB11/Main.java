
public class Main {
	  public static void main(String[] args) {
	        BankAccount sharedAccount = new BankAccount();

	        new Thread(){
	            public void run(){sharedAccount.withdraw(1.00);}
	        }.start();

	        new Thread(){
	            public void run(){sharedAccount.deposit(1.00);}
	        }.start();

	        new Thread(){
	            public void run(){sharedAccount.withdraw(1.00);}
	        }.start();

	        new Thread(){
	            public void run(){sharedAccount.deposit(2.00);}
	        }.start();

	        new Thread(){
	            public void run(){sharedAccount.withdraw(1.00);}
	        }.start();

	        new Thread(){
	            public void run(){sharedAccount.deposit(2.00);}
	        }.start();



	    }
}
