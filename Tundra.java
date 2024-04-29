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
        System.out.println("You walk out into the snowy expanse. The frigid air whips, blowing powdery flakes against your face. But wait...through the thick snowfall, you see a figure flying towards you...it's Dr. Strix! You put your arm out and she lands, perched, and delivers a riddle:");
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