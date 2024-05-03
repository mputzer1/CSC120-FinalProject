import java.util.Scanner;

/**
 * The rainforest class that extends the biome and contains the camel and cactus
 */
public class Rainforest extends Biome {
    private FloraFauna poisonDartFrog; 
    private FloraFauna cacao;
    private FloraFauna croczilla;

    /**
     * Constructor for rainforest class with information about FloraFauna
     */
    public Rainforest() {
        super("rainforest.png");
        this.poisonDartFrog = new FloraFauna("poison dart frog", 3, "Theo"); 
        this.cacao = new FloraFauna("cacao", 6, "Barbara");
        this.croczilla = new FloraFauna("croczilla", 10, "croco");
    }

    /**
     * Getter for frog
     * @return the frog object
     */
    public FloraFauna getAnimal() {
        return this.poisonDartFrog;
    }

    /**
     * Getter for cacao
     * @return the cacao object
     */
    public FloraFauna getPlant() {
        return this.cacao;
    }

    public String getImagePath() {
        return super.getImagePath();
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return poison dart frog or null.
     * @param scanner Scanner from the game loop class
     * @return poison dart frog object or null
     */
    public FloraFauna animalRiddle(Scanner scanner) {
        if (riddle(scanner, "poison dart frog", "croczilla", "FrogRiddle.txt")) {
            return this.poisonDartFrog;
        } else {
            return null;
        }
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return cacao or null.
     * @param scanner Scanner from the game loop class
     * @return cacao object or null
     */
    public FloraFauna plantRiddle(Scanner scanner) {
        if (riddle(scanner, "cacao", "croczilla", "CacaoRiddle.txt")) {
            return this.cacao;
        } else {
            return null;
        }
    }

    /**
     * Converts name for rainforest class to a string
     * @return "rainforest" string
     */
    public String toString() {
        return "rainforest";
    }

    
    /**
     * Tells user they have entered the forest canopy and quizzes them before potentially giving them the monster object
     * @param scanner Scanner from the game loop class
     * @return croczilla object or null
     */
    public FloraFauna secretLocation(Scanner scanner) {
        System.out.println("\nYou have entered the forest canopy. If you can answer the following bonus question about this location, you will be able to capture the croczilla and end its rein of terror!");
        System.out.println("\nDr. Athene Strix: What percentage of sunlight does the rainforest canopy intercept? *No percent symbol needed in your answer.");
        String userResponse = "";
        userResponse = scanner.nextLine().toLowerCase();
        if (userResponse.equals("95")) {
            System.out.println("You are correct! You have obtained the elusive croczilla and are one step closer to defeating Professor Fossileus Fueleus!");
            return this.croczilla;
        } else {
            System.out.println("You answered incorrectly, but escaped the croczilla by staying in the trees. You have retained your inventory!");
            return null;
        }
    }

}