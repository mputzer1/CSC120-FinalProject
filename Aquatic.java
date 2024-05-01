import java.util.Scanner;

/**
 * The aquatic class that extends the biome and contains the dolphin and sea anemone
 */
public class Aquatic extends Biome {
    private FloraFauna dolphin;
    private FloraFauna sea_anemone;
    private FloraFauna kraken;

    /**
     * Constructor for aquatic class with information about FloraFauna
     */
    public Aquatic() {
        this.dolphin = new FloraFauna("dolphin", 4, "Dorothy"); 
        this.sea_anemone = new FloraFauna("sea anemone", 5, "Flounder");
        this.kraken = new FloraFauna("kraken", 2, "Sam");
    }

    /**
     * Getter for dolphin
     * @return the dolphin object
     */
    public FloraFauna getAnimal() {
        return this.dolphin;
    }

    /**
     * Getter for anemone
     * @return the anemone object
     */
    public FloraFauna getPlant() {
        return this.sea_anemone;
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return dolphin or null.
     * @param Scanner s from the game loop class
     * @return dolphin object or null
     */
    public FloraFauna animalRiddle(Scanner s) {
        if (riddle(s, "dolphin", "kraken", "DolphinRiddle.txt")) {
            return this.dolphin;
        } else {
            return null;
        }
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return anemone or null.
     * @param Scanner s from the game loop class
     * @return sea anemone object or null
     */
    public FloraFauna plantRiddle(Scanner s) {
        if (riddle(s, "sea anemone", "kraken", "AnemoneRiddle.txt")) {
            return this.sea_anemone;
        } else {
            return null;
        }
    }

    public String toString() {
        return "aquatic";
    }

    public FloraFauna secretLocation(Scanner s) {
        System.out.println("\nYou have reached the coral reef. If you can answer the following bonus question about this location, you will be able to capture the kraken and end its rein of terror!");
        System.out.println("\nDr. Athene Strix: Coral reefs are home to what percentage of the world's marine life? *No percent symbol needed in your answer.");
        String userResponse = "";
        userResponse = s.nextLine().toLowerCase();
        if (userResponse.equals("25")) {
            System.out.println("You are correct! You have obtained the elusive kraken and are one step closer to defeating Professor Fossileus Fueleus!");
            return this.kraken;
        } else {
            System.out.println("You answered incorrectly, but reached a passing barge before the kraken could eat your inventory!");
            return null;
        }
    }
}