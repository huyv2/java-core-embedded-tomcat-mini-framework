package hr.ewallet.domain.account;

public class Activity {
	public static Activity createActivity() {
		return new Activity();
	}
	
	private Activity() {
		// Load gl account here
	}
	
	public boolean moveMoney(Account sourceAccount, Account destinationAccount, long amount) {
		boolean isSuccess = false;
		
		// Same bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
	
	public boolean withdraw(Account account, long amount) {
		boolean isSuccess = false;
		
		// Different bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
	
	public boolean deposit(Account account, long amount) {
		boolean isSuccess = false;
		
		// Different bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
}
