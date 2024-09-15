import java.util.Scanner;

public class MainView {
    private Scanner input = new Scanner(System.in);

    public int getCowsID() {
        System.out.println("Enter the ID of the cow you want to view: ");

        int cowsID = input.nextInt();
        return cowsID;

    }

    public void displayInputError() {
        System.out.println("Invalid input. Please enter a valid cow ID.");
    }

    public void displayNotFoundData() {
        System.out.println("This ID isn't available, Please try again");
    }

    public void closeScanner() {
        input.close();
    }
}
