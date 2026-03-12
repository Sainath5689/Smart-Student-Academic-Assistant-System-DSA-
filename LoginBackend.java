// CO1: Implement searching algorithms for login authentication
import java.util.Scanner;

public class LoginBackend {
    // Store usernames and passwords together
    private String[][] credentials = {
        {"sainath", "1234"},
        {"rahul", "pass"},
        {"megha", "hello"},
        {"arjun", "admin"}
    };

    // Authenticate using linear search (simpler and correct)
    public boolean authenticate(String username, String password) {
        for (String[] pair : credentials) {
            if (pair[0].equals(username) && pair[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Smart Student Academic Assistant Login ===");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        LoginBackend login = new LoginBackend();

        if (login.authenticate(username, password)) {
            System.out.println("Login Successful! Welcome " + username);
        } else {
            System.out.println("Invalid Credentials. Please try again.");
        }

        sc.close();
    }
}