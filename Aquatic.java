import java.util.Scanner;

/**
 * The aquatic class that extends the biome and contains the dolphin and sea anemone
 */
public class Aquatic extends Biome {
    private FloraFauna dolphin;
    private FloraFauna sea_anemone;
    private String imagePath;

    /**
     * Constructor for aquatic class with information about FloraFauna
     */
    public Aquatic() {
        super("cs120_lab_image.png");
        this.dolphin = new FloraFauna("dolphin", 4, "Dorothy"); 
        this.sea_anemone = new FloraFauna("sea anemone", 5, "Flounder");
        this.imagePath = ("ocean.png");
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

    public String getImagePath() {
        return imagePath;
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
}