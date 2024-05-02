import java.util.Scanner;

/**
 * Biome class which has the file reader attribute.
 */
public class Biome {
    private FileClass FileReader;
    private FloraFauna animal;
    private FloraFauna plant;
    private FloraFauna monster;

    /**
     * Constructor for biome class
     */
    public Biome() {
        this.FileReader = new FileClass();
        this.animal = new FloraFauna(null, null, null);
        this.plant = new FloraFauna(null, null, null);
        this.monster = new FloraFauna(null, null, null);
    }

    /**
     * Getter for animal
     * @return the animal object
     */
    public FloraFauna getAnimal() {
        return this.animal;
    }

    /**
     * Getter for plant
     * @return the plant object
     */
    public FloraFauna getPlant() {
        return this.plant;
    }


    /**
     * Simple animal riddle method created so game loop recognizes that biome class contains animal riddle.
     * @param s Scanner for user answer
     * @return the animal associated with the riddle
     */
    public FloraFauna animalRiddle(Scanner s) {
        return this.animal;

    }

    /**
     * Simple plant riddle method created so game loop recognizes that biome class contains plant riddle.
     * @param s Scanner for user answer
     * @return the plant associated with the riddle
     */
    public FloraFauna plantRiddle(Scanner s) {
        return this.plant;
    }

    /**
     * Allows riddles for child classes to be read and answered.
     * @param s Scanner that reads user response
     * @param floraFauna String that is riddle subject
     * @param monster String that is attacking user
     * @param fileName string that is associated with riddle subject
     * @return boolean (whether riddle was answered correctly)
     */
    public boolean riddle(Scanner s, String floraFauna, String monster, String fileName) {
        System.out.println("");
        this.FileReader.fileReader(fileName);
        String userResponse = "";
        int incorrectCounter = 0;
        while (true) {
            System.out.println("\nEnter your answer:");
            userResponse = s.nextLine().toLowerCase();
            if (!userResponse.equals(floraFauna)) {
                System.out.println("\nYou've answered incorrectly!");
                incorrectCounter += 1;
                if (incorrectCounter < 3) {
                    System.out.println("The " + monster + " is " + (3 - incorrectCounter) + " feet away.");
                }
                if (incorrectCounter == 3) {
                    System.out.println("Your inventory has been eaten!");
                    return false;
                }
            }
            if (userResponse.equals(floraFauna)) {
                System.out.println("\nYou've answered correctly! The " + floraFauna + " has been added to your inventory.");
                return true;
            }
        }
    }

    /** 
     * Method converts biome class to a string
    */
    public String toString() {
        return "biome";
    }

    /**
     * Basic secretLocation method created so the game loop recognizes that this method is defined for the type biome in the generic if statement loop
     * @param s Scanner for user answer
     * @return the monster 
     */
    public FloraFauna secretLocation(Scanner s) {
        System.out.println("You've entered the secret spot.");
        return this.monster;
    }
}


