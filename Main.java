import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Account account = new Account();
		Balance balance = new Balance();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to MyBank!");
		System.out.println(" ");
		System.out.println("==================");
		System.out.println(" ");

		while(true){

			System.out.println("Select:");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("0. Exit");
			System.out.print("- ");
			int selection = Integer.parseInt(scanner.nextLine());

			switch(selection){

				case 1:
					System.out.print("Enter your login and password separated by a space: ");
					String loginpass = scanner.nextLine();
					String[] lp = loginpass.split(" ");
					String log = lp[0];
					String pas = lp[1];

					if(account.getLognPas(log, pas)){
						System.out.println("Correct login and password");

						String[] giveInfo = {log, pas};
						balance.setMain(giveInfo);

						while(true) {
							System.out.println(" ");
							System.out.println("Menu:");
							System.out.println(" ");
							System.out.println("1. Check balance");
							System.out.println("2. Add money");
							System.out.println("3. New transaction");
							System.out.println("4. Transactions history");
							System.out.println("0. Exit");

							int select = Integer.parseInt(scanner.nextLine());

							switch(select){
								case 0:
									return;

								case 1:
									if(balance.getBalance() <= 0){
										System.out.println("No money - no honey");
									} else {
										System.out.println(balance.getBalance());
									}
									break;

								case 2:
									System.out.print("Insert money: ");
									int moneys = Integer.parseInt(scanner.nextLine());

									balance.addToBalance(moneys);
									balance.setAccBalance();
									System.out.println("Moneys successfully added to your balance!");

									break;

								case 3:
									System.out.print("Enter sum of transaction: ");
									int transaction = Integer.parseInt(scanner.nextLine());

										balance.transaction(transaction);
										balance.setAccBalance();
										System.out.println("Moneys successfully sent to another user!");

									break;

								case 4:
									System.out.println(balance.myStory());
									break;
							}
						}
					} else {
						System.out.println("Wrong login or password");
					}

					break;

				case 2:
					System.out.print("Enter your new login and password separated by a space: ");
					String logpas = scanner.nextLine();
					String[] lognpas = logpas.split(" ");
					String login = lognpas[0];
					String password = lognpas[1];

					account.setLogPas(login, password);
					System.out.println("Registration is over");

					break;

				case 0:

					return;

			}
		}
	}
}