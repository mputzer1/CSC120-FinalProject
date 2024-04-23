import java.util.Scanner;

public class Biome {
    private FileReader FileReader;

    public Biome() {
        this.FileReader = new FileReader();
    }

    public boolean riddle(Scanner s, String FloraFauna, String Monster, String filename) {
        this.FileReader.RiddleReader(filename);
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
                    System.out.println("\nYou've been eaten!");
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


