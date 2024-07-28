import java.util.LinkedHashMap;

public class Account {

	private String login;
	private String password;


	LinkedHashMap<String, String> logPas = new LinkedHashMap<>();

		public void setLogPas (String log, String pas){
			login = log;
			password = pas;
			logPas.put(log, pas);
		}

		public boolean getLognPas(String logn, String pass){
			if (logPas.containsKey(logn) && logPas.containsValue(pass)){
				return true;
			}
			return false;
		}
}
