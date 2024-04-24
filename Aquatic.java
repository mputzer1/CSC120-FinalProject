import java.util.Scanner;

/**
 * The aquatic class that extends the biome and contains the dolphin and sea anemone
 */
public class Aquatic extends Biome {
    private FloraFauna dolphin;
    private FloraFauna sea_anemone;

    /**
     * Constructor for aquatic class with information about FloraFauna
     */
    public Aquatic() {
        this.dolphin = new FloraFauna("dolphin", 4, "Dorothy"); 
        this.sea_anemone = new FloraFauna("sea anemone", 5, "Flounder");
    }

    /**
     * Getter for dolphin
     * @return the dolphin object
     */
    public FloraFauna getDolphin() {
        return this.dolphin;
    }

    /**
     * Prints welcome message
     */
    public void welcome() {
        System.out.println("Aquatic welcome");
        //Reads welcome message
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return dolphin or null.
     * @param Scanner s from the game loop class
     * @return dolphin object or null
     */
    public FloraFauna dolphinRiddle(Scanner s) {
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
    public FloraFauna anemoneRiddle(Scanner s) {
        if (riddle(s, "sea anemone", "kraken", "AnemoneRiddle.txt")) {
            return this.sea_anemone;
        } else {
            return null;
        }
    }
}