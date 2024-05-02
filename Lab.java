import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains attributes for the lab class
 */
public class Lab {
    private ArrayList<FloraFauna> inventory;
    private int nClearInventory;

    /**
     * Constructor for the lab class
     */
    public Lab() {
        this.inventory = new ArrayList<>();
        this.nClearInventory = 0;
    }

    public static String getImagePath() {
        return "lab.png";
    }

    /**
     * Getter for the inventory
     * @return inventory with the creatures
     */
    public ArrayList<FloraFauna> getInventory() {
        return this.inventory;
    }

    /**
     * Clears inventory and counts how many times inventory has been cleared for final scoring purposes. Also resets user location.
     * @return string that says "lab", which resets the user location in the game loop
     */
    public String resetInventory() {
        inventory.clear();
        nClearInventory += 1;
        return "lab";
    }

    /**
     * Allows user to check inventory contents
     * @param userInput scanner for if user would like to check their inventory
     */
    public void checkInventory(Scanner userInput) {
        System.out.println("\nYou are back to the lab. Would you like to check your inventory?");
        String userResponse = userInput.nextLine().toLowerCase();
        while (!userResponse.equals("yes") && !userResponse.equals("no")) {
            System.out.println("I don't recognize that answer");
            userResponse = userInput.nextLine().toLowerCase();
        }
        if (userResponse.equals("yes")) {
            System.out.println("\n==============");
            System.out.println("YOUR INVENTORY");
            System.out.println("==============");
            if (inventory.isEmpty()) {
                System.out.println("Your inventory is empty.");
            } else {
                for (int i = 0; i < inventory.size(); i++) {
                    System.out.println(inventory.get(i));
                }
            }
        } else {
           System.out.println("\nThe game continues!"); 
        }
    }
    
    /**
     * 
     * @param userInput Scanner for if they want to submit their inventory
     * @param username String for username 
     * @param fileClass FileClass object for printing a leaderboard for the user
     * @param stillPlaying boolean to be updated if the game ends
     * @return stillPlaying boolean determines whether game ended or not
     */
    public boolean submitInventory(Scanner userInput, String username, FileClass fileClass, boolean stillPlaying) {
        System.out.println("\nWould you like to submit your inventory for review? Warning: the game will end.");
        String userResponse = userInput.nextLine().toLowerCase();
        while (!userResponse.equals("yes") && !userResponse.equals("no")) {
            System.out.println("\nI don't recognize " + "'" + userResponse +"'");
            userResponse = userInput.nextLine().toLowerCase();
        }
        if (userResponse.equals("yes")) {
            int score = inventory.size() - nClearInventory;
            System.out.println("\nYou found " + inventory.size()+ " animals/plants. Your inventory was eaten " + nClearInventory + " time(s). Your final score is " + score + ".");
            fileClass.fileWriter(username + ":" + score);
            fileClass.sortedFile();
            System.out.println("\n***LEADERBOARD***");
            fileClass.fileReader("Scoreboard.txt");
            return stillPlaying = false;
        } else {
            System.out.println("\nThe game continues!");
            return stillPlaying = true; 
        }
    }
}
