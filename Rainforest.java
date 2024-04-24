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
        System.out.println("\nYou are surrounded by lush green foliage. You cannot see the sky above the forest canopy, but you feel a light sprinkle of rain. Birds are heard in the distance and you notice...");
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