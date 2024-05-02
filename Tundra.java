import java.util.Scanner;

/**
 * The tundra class that extends the biome and contains the arctic fox and fern
 */
public class Tundra extends Biome {
    private FloraFauna arctic_fox;
    private FloraFauna fern;
    private FloraFauna yeti;

    /**
     * Constructor for tundra class with information about FloraFauna
     */
    public Tundra() {
        this.arctic_fox = new FloraFauna("arctic fox", 6, "Gary"); 
        this.fern = new FloraFauna("fern", 5, "Finn");
        this.yeti = new FloraFauna("yeti", 4, "Joe");
    }

    /**
     * Getter for arctic fox
     * @return the fox object
     */
    public FloraFauna getAnimal() {
        return this.arctic_fox;
    }

    /**
     * Getter for fern
     * @return the fern object
     */
    public FloraFauna getPlant() {
        return this.fern;
    }
    

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return fox or null.
     * @param s Scanner from the game loop class
     * @return fox object or null
     */
    public FloraFauna animalRiddle(Scanner s) {
        if (riddle(s, "arctic fox", "yeti", "FoxRiddle.txt")) {
            return this.arctic_fox;
        } else {
            return null;
        }
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return fern or null.
     * @param s Scanner from the game loop class
     * @return fern object or null
     */
    public FloraFauna plantRiddle(Scanner s) {
        if (riddle(s, "fern", "yeti", "FernRiddle.txt")) {
            return this.fern;
        } else {
            return null;
        }
    }

    /**
     * Converts name for tundra class to a string
     * @return "tundra" string
     */
    public String toString() {
        return "tundra";
    }


    /**
     * Tells user they have entered the ice cave and quizzes them before potentially giving them the monster object
     * @param s Scanner from the game loop class
     * @return yeti object or null
     */
    public FloraFauna secretLocation(Scanner s) {
        System.out.println("\nYou have reached the ice cave. If you can answer the following bonus question about the tundra, you will be able to capture the yeti and end its rein of terror!");
        System.out.println("\nDr. Athene Strix: The sun shines up to BLANK hours per day in the tundra summer growing season?");
        String userResponse = "";
        userResponse = s.nextLine().toLowerCase();
        if (userResponse.equals("24")) {
            System.out.println("You are correct! You have obtained the elusive yeti and are one step closer to defeating Professor Fossileus Fueleus!");
            return this.yeti;
        } else {
            System.out.println("You answered incorrectly, but ran down the mountain before the yeti could see you and eat your inventory!");
            return null;
        }
    }

}