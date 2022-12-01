package hr.ewallet.domain.card;

public class Activity {
	public static Activity createActivity() {
		return new Activity();
	}
	
	private Activity() {
		// Load card gl account service here
	}
	
	public boolean moveMoney(Card sourceCard, Card destinationCard, long amount) {
		boolean isSuccess = false;
		
		// Same bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
	
	public boolean withdraw(Card account, long amount) {
		boolean isSuccess = false;
		
		// Different bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
	
	public boolean deposit(Card account, long amount) {
		boolean isSuccess = false;
		
		// Different bank: Process move here and assign true or false to isSuccess
		
		return isSuccess;
	}
}
