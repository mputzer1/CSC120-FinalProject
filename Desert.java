import java.util.Scanner;

/**
 * The desert class that extends the biome and contains the camel and cactus
 */
public class Desert extends Biome {
    private FloraFauna camel;
    private FloraFauna cactus;
    private FloraFauna sharknado;

    /**
     * Constructor for desert class with information about FloraFauna
     */
    public Desert() {
        this.camel = new FloraFauna("camel", 2, "Tom");
        this.cactus = new FloraFauna("cactus", 3, "Janice");
        this.sharknado = new FloraFauna("sharknado", 20, "Sharky");
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

    public FloraFauna secretLocation(Scanner s) {
        System.out.println("\nYou have reached the oasis. If you can answer the following bonus question about this location, you will be able to capture the sharknado and end its rein of terror!");
        System.out.println("\nDr. Athene Strix: Deserts cover what percentage of Earth's land area? *No percent symbol needed in your answer.");
        String userResponse = "";
        userResponse = s.nextLine().toLowerCase();
        if (userResponse.equals("20")) {
            System.out.println("You are correct! You have obtained the elusive sharknado and are one step closer to defeating Professor Fossileus Fueleus!");
            return this.sharknado;
        } else {
            System.out.println("You answered incorrectly, but hid in a sand cave before the sharknado could eat your inventory!");
            return null;
        }
    }

}