import java.util.Scanner;

/**
 * The rainforest class that extends the biome and contains the camel and cactus
 */
public class Rainforest extends Biome {
    private FloraFauna poison_dart_frog; 
    private FloraFauna cacao;

    /**
     * Constructor for rainforest class with information about FloraFauna
     */
    public Rainforest() {
        this.poison_dart_frog = new FloraFauna("poison dart frog", 3, "Theo"); 
        this.cacao = new FloraFauna("cacao", 6, "Barbara");
    }

    /**
     * Getter for the poison dart frog
     * @return the poison dart frog object
     */
    public FloraFauna getFrog() {
        return this.poison_dart_frog;
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return poison dart frog or null.
     * @param Scanner s from the game loop class
     * @return poison dart frog object or null
     */
    public FloraFauna frogRiddle(Scanner s) {
        if (riddle(s, "poison dart frog", "croczilla", "FrogRiddle.txt")) {
            return this.poison_dart_frog;
        } else {
            return null;
        }
    }

    /**
     * Calls riddle method and checks if true or false is returned to determine whether to return cacao or null.
     * @param Scanner s from the game loop class
     * @return cacao object or null
     */
    public FloraFauna cacaoRiddle(Scanner s) {
        if (riddle(s, "cacao", "croczilla", "CacaoRiddle.txt")) {
            return this.cacao;
        } else {
            return null;
        }
    }

}