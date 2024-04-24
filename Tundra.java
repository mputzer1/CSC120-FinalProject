import java.util.Scanner;

/**
 * The tundra class that extends the biome and contains the arctic fox and fern
 */
public class Tundra extends Biome {
    private FloraFauna arctic_fox;
    private FloraFauna fern;

    /**
     * Constructor for tundra class with information about FloraFauna
     */
    public Tundra() {
        this.arctic_fox = new FloraFauna("arctic fox", 6, "Gary"); 
        this.fern = new FloraFauna("fern", 5, "Finn");
    }

    /**
     * Getter for fox
     * @return the fox object
     */
    public FloraFauna getFox() {
        return this.arctic_fox;
    }

    /**
     * Prints welcome message
     */
    public void welcome() {
        System.out.println("Tundra Welcome!");
        //Reads welcome message
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return fox or null.
     * @param Scanner s from the game loop class
     * @return fox object or null
     */
    public FloraFauna foxRiddle(Scanner s) {
        if (riddle(s, "arctic fox", "yeti", "FoxRiddle.txt")) {
            return this.arctic_fox;
        } else {
            return null;
        }
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return fern or null.
     * @param Scanner s from the game loop class
     * @return fern object or null
     */
    public FloraFauna fernRiddle(Scanner s) {
        if (riddle(s, "fern", "yeti", "FernRiddle.txt")) {
            return this.fern;
        } else {
            return null;
        }
    }
}