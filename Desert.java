import java.util.Scanner;

/**
 * The desert class that extends the biome and contains the camel and cactus
 */
public class Desert extends Biome {
    private FloraFauna camel;
    private FloraFauna cactus;

    /**
     * Constructor for desert class with information about FloraFauna
     */
    public Desert() {
        this.camel = new FloraFauna("camel", 2, "Tom");
        this.cactus = new FloraFauna("cactus", 3, "Janice");
    }

    /**
     * Getter for camel
     * @return the camel object
     */
    public FloraFauna getAnimal() {
        return this.camel;
    }

    /**
     * Getter for cactus
     * @return the cactus object
     */
    public FloraFauna getPlant() {
        return this.cactus;
    }


    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return camel or null.
     * @param Scanner s from the game loop class
     * @return camel object or null
     */
    public FloraFauna animalRiddle(Scanner s) { 
        if (riddle(s, "camel", "sharknado", "CamelRiddle.txt")) {
            return this.camel;
        } else {
            return null;
        }
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return cactus or null.
     * @param Scanner s from the game loop class
     * @return cactus object or null
     */
    public FloraFauna plantRiddle(Scanner s) {
        if (riddle(s, "cactus", "sharknado", "CactusRiddle.txt")) {
            return this.cactus;
        } else {
            return null;
        }
    }

    public String toString() {
        return "desert";
    }

}