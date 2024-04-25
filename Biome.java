import java.util.Scanner;

/**
 * Biome class which has the file reader attribute.
 */
public class Biome {
    private FileReader FileReader;

    /**
     * Constructor for biome class
     */
    public Biome() {
        this.FileReader = new FileReader();
    }

    /**
     * Allows riddles for child classes to be read and answered.
     * @param Scanner s that reads user response
     * @param String FloraFauna that is riddle subject
     * @param String Monster that is attacking user
     * @param String filename that is associated with riddle subject
     * @return boolean (whether riddle was answered correctly)
     */
    public boolean riddle(Scanner s, String FloraFauna, String Monster, String filename) {
        this.FileReader.messageReader(filename);
        String userResponse = "";
        int incorrectCounter = 0;
        while (true) {
            System.out.println("\nEnter your answer:");
            userResponse = s.nextLine().toLowerCase();
            if (!userResponse.equals(FloraFauna)) {
                System.out.println("\nYou've answered incorrectly!");
                incorrectCounter += 1;
                System.out.println("The " + Monster + " is " + (3 - incorrectCounter) + " step(s) away.");
                if (incorrectCounter == 3) {
                    System.out.println("\nYour inventory has been eaten!");
                    return false;
                }
            }
            if (userResponse.equals(FloraFauna)) {
                System.out.println("\nYou've answered correctly! The " + FloraFauna + " has been added to your inventory.");
                return true;
            }
        }
    }
}


