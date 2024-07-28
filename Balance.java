import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Balance {

	Main main = new Main();
	private LinkedHashMap<String[], Integer> accBalance = new LinkedHashMap<>();

	private int balance;
	private String[] getInfo;
	private ArrayList<Integer> transactions = new ArrayList<>();

	public void setMain(String[] info){
		getInfo = info;
	}

	public void addToBalance(int mon) {

		balance += mon;
	}

	public int getBalance() {
		return balance;
	}

	public void setAccBalance(){
		accBalance.put(getInfo, balance);
	}

	public int transaction(int transac){
		if(balance == 0){
			return 0;
		} else if(transac > balance){
			return 0;
		}
		transactions.add(transac);
		balance = balance - transac;
		return balance;
	}

	public ArrayList<Integer> myStory(){
		return transactions;
	}
}
