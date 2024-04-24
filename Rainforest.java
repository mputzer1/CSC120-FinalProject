import java.util.Scanner;

public class Rainforest extends Biome {
    private FloraFauna poison_dart_frog; 
    private FloraFauna cacao;

    public Rainforest() {
        this.poison_dart_frog = new FloraFauna("poison dart frog", 3, "Theo"); 
        this.cacao = new FloraFauna("cacao", 6, "Barbara");
    }

    public FloraFauna getFrog() {
        return this.poison_dart_frog;
    }

    public void welcome() {
        System.out.println("\nYou notice a large tree...");
        //Reads welcome message
        //or send to file class and have specific lines
    }

    public FloraFauna frogRiddle(Scanner s) {
        if (riddle(s, "poison dart frog", "croczilla", "FrogRiddle.txt")) {
            return this.poison_dart_frog;
        } else {
            return null;
        }
    }

    public FloraFauna cacaoRiddle(Scanner s) {
        if (riddle(s, "cacao", "croczilla", "CacaoRiddle.txt")) {
            return this.cacao;
        } else {
            return null;
        }
    }

}