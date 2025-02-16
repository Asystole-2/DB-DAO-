package BusinessObjects;

public class menuOptions {

    private final  String[] options = {
            " List all expenses",
            " Add a new expense",
            " Delete an expense",
            " List all income",
            " Add a new income",
            " Delete an income",
            " List all transactions for a particular month",
            " Exit"};

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

