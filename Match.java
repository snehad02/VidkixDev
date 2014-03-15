import java.util.HashMap;
import java.util.Scanner;

public class Match {
	public static void main(String[] args) {
		System.out.println("Enter email");
		Scanner i = new Scanner(System.in);
		// Using following variable as placeholder for email box
		String emailBox = i.next();

		boolean isValidEmail = emailBox
				.matches("\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		if (isValidEmail)
			System.out.println("Entered email is valid");
		else
			System.out.println("Invalid email");

		// Using following variable as placeholder for password box
		System.out.println("Enter password");
		String pwdBox = i.next();
		boolean isValidPwd = pwdBox
				.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=_~])(?=\\S+$).{6,}$");
		if (isValidPwd)
			System.out.println("Entered password is valid");
		else
			System.out.println("Invalid password");

		// Using following variable as placeholder for password strength
		int pwdStrength = 0;
		String pStrength;
		if (pwdBox.length() > 6)
			pwdStrength += 1;

		if (pwdBox.matches("([a-z].[A-Z])|([A-Z].[a-z])"))
			pwdStrength += 1;

		if (pwdBox.matches("[!@#$%^&+=_~]"))
			pwdStrength += 1;

		if (pwdBox.matches(".*[!@#$%^&+=_~].*[!@#$%^&+=_~]"))
			pwdStrength += 1;

		switch (pwdStrength) {
		case (0):
		case (1): {
			pStrength = "weak";
			System.out.println("Password is " + pStrength);
		}
		case (2): {
			pStrength = "good";
			System.out.println("Password is " + pStrength);
		}
		case (3): {
			pStrength = "strong";
			System.out.println("Password is " + pStrength);
		}
		case (4): {
			pStrength = "very strong";
			System.out.println("Password is " + pStrength);
		}
		}

		HashMap<String, String> m = new HashMap<String, String>();

		while (true) {
			System.out.println("Are you a returning user??");
			System.out.println("Enter y or n");
			String userResponse = i.nextLine();
			if (userResponse.equals("y")) {
				System.out.println("Enter username");

				String username = i.nextLine();
				if (m.containsKey(username)) {
					System.out.println("Enter password");

					while (true) {
						String password = i.nextLine();
						if (m.get(username).equals(password)) {
							System.out
									.println("User authentication Successful");
							break;
						} else
							System.out
									.println("Wrong password!!! Please re-enter again");
					}
				} else {
					System.out.println("Username does not exist");
					System.out.println("Creating new user");
					System.out.println("Enter password");
					String password = i.nextLine();
					m.put(username, password);
					System.out.println("New user created");

				}
			} else {
				System.out.println("Please register by entering username");
				String username = i.nextLine();
				while (true) {
					if (m.containsKey(username)) {
						System.out
								.println("User already exists, re-enter username");
						username = i.nextLine();
					} else {
						System.out.println("Please enter password");
						String password = i.nextLine();
						m.put(username, password);
						System.out.println("New user created");
						break;
					}
				}

				/*
				 * while (true) { System.out.println("Please register");
				 * System.out.println("Enter username");
				 * 
				 * String username = i.nextLine();
				 * 
				 * while (true) { if (m.containsKey(username)) { System.out
				 * .println
				 * ("Username already exists, please eneter a new username");
				 * username = i.nextLine(); } else {
				 * System.out.println("Enter password"); String password =
				 * i.nextLine(); m.put(username, password);
				 * System.out.println("New user created"); break; } break; }
				 * break; }
				 */

			}
		}

	}
}