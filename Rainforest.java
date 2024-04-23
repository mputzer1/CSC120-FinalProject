import java.util.Scanner;

public class Rainforest extends Biome {
    private FloraFauna poison_dart_frog; //Would it be better to just create a string for poison dart frog? //Should we have important info about posion dart frog that user can read?
    private FloraFauna cacao;
    private Monster croczilla; //Is this really necessary?


    public Rainforest() {
        this.poison_dart_frog = new FloraFauna("poison dart frog", 3, "Theo"); 
        this.cacao = new FloraFauna("cacao", 6, "Barbara");
        this.croczilla = new Monster("croczilla");
    }

    public void welcome() {
        System.out.println("\nYou notice a large tree...");
        //Reads welcome message
        //or send to file class and have specific lines
    }

    public FloraFauna frogriddle(Scanner s) {
        if (riddle(s, "poison dart frog", "croczilla", "FrogRiddle.txt")) {
            return this.poison_dart_frog;
        } else {
            return null;
        }
    }

    public FloraFauna cacaoriddle(Scanner s) {
        if (riddle(s, "cacao", "croczilla", "CacaoRiddle.txt")) {
            return this.cacao;
        } else {
            return null;
        }
    }

}