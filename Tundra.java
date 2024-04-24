import java.util.Scanner;

public class Tundra extends Biome {
    private FloraFauna arctic_fox;
    private FloraFauna fern;

    public Tundra() {
        this.arctic_fox = new FloraFauna("arctic fox", 6, "Gary"); 
        this.fern = new FloraFauna("fern", 5, "Finn");
    }

    public FloraFauna getFox() {
        return this.arctic_fox;
    }

    public void welcome() {
        System.out.println("Tundra Welcome!");
        //Reads welcome message
    }

    public FloraFauna foxRiddle(Scanner s) {
        if (riddle(s, "arctic fox", "yeti", "FoxRiddle.txt")) {
            return this.arctic_fox;
        } else {
            return null;
        }
    }

    public FloraFauna fernRiddle(Scanner s) {
        if (riddle(s, "fern", "yeti", "FernRiddle.txt")) {
            return this.fern;
        } else {
            return null;
        }
    }
}