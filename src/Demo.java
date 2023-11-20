import java.util.Scanner;
public class Demo {
    static Scanner input = new Scanner(System.in);
    static String login_array[][] = new String[1][2];

    static String item_array[][] = new String[0][6];
    static String supplie_array[][] = new String[0][2];

    public static void main(String[] args) {
        login_array[0][0] = "parami";
        login_array[0][1] = "0311";

        clearConsole();
        login();
        HomePage();
    }

    //    --------- Login Page ---------
    private static void login() {
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println("|                                LOGIN PAGE                                 |");
        System.out.println("+---------------------------------------------------------------------------+");
        System.out.println();

        System.out.print("User name : ");
        String username = input.next();

        boolean check_user_name = verifying_user_credential(username);

        String password;

        if (check_user_name) {
            do {
                System.out.print("Password: ");
                password = input.next();

                boolean check_passwords = verifying_password_credential(password);
                if (check_passwords) {
                    HomePage();
                    clearConsole();
                } else {
                    System.out.println("Password is Incorrect... Please Try Again!");
                }
            } while (true);
        } else {
            System.out.println("Username is Invalid.. Please Try Again!");
            login();
        }
    }
    //    --------- Check User's Name ---------
    private static boolean verifying_user_credential(String username) {
        for (String[] users : login_array) {
            if (users[0].equals(username)) {
                return true;
            }
        }
        return false;
    }
    //    --------- Check User's Password ---------
    private static boolean verifying_password_credential(String password) {
        for (String[] pw : login_array) {
            if (pw[1].equals(password)) {
                return true;
            }
        }
        return false;
    }
    //    --------- Home Page ---------
    private static void HomePage() {
        int option;
        while (true) {
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.println("|                 WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                   |");
            System.out.println("+---------------------------------------------------------------------------+\n");
            System.out.println();
            System.out.println("[1] Change the Credentials"+"                  "+"[2] Supplier Manage");
            System.out.println("[3] Stock Manage          "+"                  "+"[4] Log out        ");
            System.out.println("[5] Exit the System       "+"                                        ");

            System.out.println();

            System.out.print("Enter an option to continue > ");
            option = input.nextInt();

            switch (option) {
                case 1 :
                    clearConsole();
                    break;

                case 2 :
                    clearConsole();
                    break;
                case 3 :
                    clearConsole();
                    break;

                case 4 :
                    clearConsole();
                    logout();
                case 5 :
                    clearConsole();
                    System.exit(5);
            }
        }
    }
   //    --------- Clear Console ---------
    private static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }
    //    --------- Logout ---------
    private static void logout() {
        login();
        clearConsole();
    }
}
