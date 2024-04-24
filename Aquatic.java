import java.util.Scanner;

public class Aquatic extends Biome {
    private FloraFauna dolphin;
    private FloraFauna sea_anemone;
    private Monster kraken;

    public Aquatic() {
        this.dolphin = new FloraFauna("dolphin", 4, "Dorothy"); 
        this.sea_anemone = new FloraFauna("sea anemone", 5, "Flounder");
        this.kraken = new Monster("kraken");
    }

    public FloraFauna getDolphin() {
        return this.dolphin;
    }

    public void welcome() {
        System.out.println("Aquatic welcome");
        //Reads welcome message
    }

    public FloraFauna dolphinRiddle(Scanner s) {
        if (riddle(s, "dolphin", "kraken", "DolphinRiddle.txt")) {
            return this.dolphin;
        } else {
            return null;
        }
    }

    public FloraFauna anemoneRiddle(Scanner s) {
        if (riddle(s, "sea anemone", "kraken", "AnemoneRiddle.txt")) {
            return this.sea_anemone;
        } else {
            return null;
        }
    }
}