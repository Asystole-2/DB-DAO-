package BusinessObjects;

public class menuOptions {

    private final  String[] options = {
            "1. List all expenses",
            "2. Add a new expense",
            "3. Delete an expense",
            "4. List all income",
            "5. Add a new income",
            "6. Delete an income",
            "7. List all transactions for a particular month",
            "Exit"};

    public void menuOptions() {

        System.out.println("\n==============================");
        System.out.println(" **     EXPENSE MANAGER    ** ");
        System.out.println("==============================");
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s\n", i + 1, options[i]);
        }
        System.out.println("==============================");
        System.out.print("Enter your choice: ");

    };
}

